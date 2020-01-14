package com.nexters.moss.di

import org.koin.dsl.module

// 매개변수로 get() 을 사용하면 선언한 클래스중 알맞은 클래스를 알아서 넣어준다.
val appModule = module {
    // single<C> { 생성자 } 싱글톤 객체 생성
    // factory<C> { 생성자 } 일반 객체 생성
}