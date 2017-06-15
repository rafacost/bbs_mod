package com.rafacost3d.bbs_mod.init;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class BBSMarketData {
    @SerializedName("itemKey")
    @Expose
    private String itemKey;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("unitPrice")
    @Expose
    private Double unitPrice;

    public BBSMarketData(String itemKey, Integer quantity, Double unitPrice) {
        super();
        this.itemKey = itemKey;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
