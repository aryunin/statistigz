package com.statistigz.main.mapper;

public interface Mapper<SRC, TGT> {
    TGT mapTo(SRC src);
    SRC mapFrom(TGT tgt);
}
