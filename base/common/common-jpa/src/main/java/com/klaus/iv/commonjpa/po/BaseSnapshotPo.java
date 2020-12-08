package com.klaus.iv.commonjpa.po;

import lombok.Data;

import java.io.Serializable;
@Data
public class BaseSnapshotPo<T extends BaseSnapshotPo<T>> extends BasePo<T> implements Serializable {
    private Integer version;
}
