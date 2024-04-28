package com.statistigz.common.util;

public interface Mapper<SRC, TGT> {
    TGT mapTo(SRC src);
    SRC mapFrom(TGT tgt);
}
