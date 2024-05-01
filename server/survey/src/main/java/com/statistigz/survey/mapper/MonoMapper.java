package com.statistigz.survey.mapper;

import reactor.core.publisher.Mono;

public interface MonoMapper <SRC, TGT> {
    Mono<TGT> mapTo(SRC src);
    Mono<SRC> mapFrom(TGT tgt);
}
