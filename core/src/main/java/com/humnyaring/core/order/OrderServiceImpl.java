package com.humnyaring.core.order;

import com.humnyaring.core.discount.DiscountPolicy;
import com.humnyaring.core.discount.FixDiscountPolicy;
import com.humnyaring.core.member.Member;
import com.humnyaring.core.member.MemberRepository;
import com.humnyaring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
