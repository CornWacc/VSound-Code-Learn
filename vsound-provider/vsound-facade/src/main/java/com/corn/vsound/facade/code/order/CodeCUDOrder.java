package com.corn.vsound.facade.code.order;


import com.corn.boot.annotations.CudParamsCheck;
import com.corn.boot.base.strategy.CUDOrder;
import com.corn.boot.enums.CudTypeEnum;

public class CodeCUDOrder extends CUDOrder {

    private static final long serialVersionUID = -930685417167740238L;

    @CudParamsCheck(cudTypes = {CudTypeEnum.UPDATE,CudTypeEnum.DELETE})
    private String codeId;

    @CudParamsCheck(cudTypes = {CudTypeEnum.CREATE})
    private String codeName;

    private String codeType;

    private Integer codeLevel;

    private String fromProjectId;

    private String codeRemark;

    private String usePosition;

    public String getCodeRemark() {
        return codeRemark;
    }

    public void setCodeRemark(String codeRemark) {
        this.codeRemark = codeRemark;
    }

    public String getUsePosition() {
        return usePosition;
    }

    public void setUsePosition(String usePosition) {
        this.usePosition = usePosition;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public Integer getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(Integer codeLevel) {
        this.codeLevel = codeLevel;
    }

    public String getFromProjectId() {
        return fromProjectId;
    }

    public void setFromProjectId(String fromProjectId) {
        this.fromProjectId = fromProjectId;
    }
}
