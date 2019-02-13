package com.quwan.beebee.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.annotation.WebFilter;


@Order(1)
@WebFilter(filterName = "SignVerifyFilter", urlPatterns = "/*")
public class SignVerifyFilter extends SignVerifyCommonFilter {

}