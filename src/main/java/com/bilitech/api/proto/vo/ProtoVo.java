package com.bilitech.api.proto.vo;

import com.bilitech.api.core.vo.BaseVo;
import com.bilitech.api.proto.dto.ProjectDto;
import com.bilitech.api.proto.enums.ProtoStatus;
import lombok.Data;

@Data
public class ProtoVo extends BaseVo {
    private String name;

    private ProtoStatus status;
}