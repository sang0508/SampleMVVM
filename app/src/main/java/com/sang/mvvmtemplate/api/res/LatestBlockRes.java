package com.sang.mvvmtemplate.api.res;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LatestBlockRes implements Serializable {

    @SerializedName("time")
    private int time;
    @SerializedName("height")
    private int height;
    @SerializedName("hash")
    private String hash;
    @SerializedName("slot")
    private int slot;
    @SerializedName("epoch")
    private int epoch;
    @SerializedName("epoch_slot")
    private int epochSlot;
    @SerializedName("slot_leader")
    private String slotLeader;
    @SerializedName("size")
    private int size;
    @SerializedName("tx_count")
    private int txCount;
    @SerializedName("output")
    private String output;
    @SerializedName("fees")
    private String fees;
    @SerializedName("block_vrf")
    private String blockVrf;
    @SerializedName("op_cert")
    private String opCert;
    @SerializedName("op_cert_counter")
    private String opCertCounter;
    @SerializedName("previous_block")
    private String previousBlock;
    @SerializedName("next_block")
    private String nextBlock;
    @SerializedName("confirmations")
    private int confirmations;


    @Override
    public String toString() {
        return "BlockResponse{" +
                "time=" + time +
                ", height=" + height +
                ", hash='" + hash + '\'' +
                ", slot=" + slot +
                ", epoch=" + epoch +
                ", epochSlot=" + epochSlot +
                ", slotLeader='" + slotLeader + '\'' +
                ", size=" + size +
                ", txCount=" + txCount +
                ", output='" + output + '\'' +
                ", fees='" + fees + '\'' +
                '}';
    }
}
