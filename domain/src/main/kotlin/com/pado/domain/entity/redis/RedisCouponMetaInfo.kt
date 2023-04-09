package com.pado.domain.entity.redis

import com.pado.domain.type.CouponGrade
import com.pado.domain.type.ExpiredPeriodUnit
import org.springframework.data.redis.core.RedisHash

@RedisHash
data class RedisCouponMetaInfo(
    val name: String, // 쿠폰 명
    val price: Long, // 쿠폰 가격
    val setPieceCount: Int, // 쿠폰을 몇 조각 모아야 교환 가능한지
    val expiredPeriodUnit: ExpiredPeriodUnit, // 쿠폰 만료 기간 단위 (월 / 주 / 일)
    val expiredPeriodNumber: Int, // 쿠폰 만료 기간 숫자 (ex. n월)
    val couponGrade: CouponGrade, // 쿠폰 종류 (unicorn/ unique... 발급될 확률. 맵에서 쿠폰 할당 선택시 당첨 확률이라고 정의하겠다.)
){
    companion object{
        fun toRedisCouponMetaInfo(couponMetaInfo: com.pado.domain.entity.CouponMetaInfo) = RedisCouponMetaInfo(
            name = couponMetaInfo.name,
            price = couponMetaInfo.price,
            setPieceCount = couponMetaInfo.setPieceCount,
            expiredPeriodUnit = couponMetaInfo.expiredPeriodUnit,
            expiredPeriodNumber = couponMetaInfo.expiredPeriodNumber,
            couponGrade = couponMetaInfo.couponGrade,
        )
    }
}