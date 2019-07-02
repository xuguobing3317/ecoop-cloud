package com.ecoop.entity.pid;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @ClassName ProfitRecordEntity
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 19:25
 * @Version 1.0
 **/
@Entity
@Table(name = "profit_record", schema = "pid_mv", catalog = "")
public class ProfitRecordEntity {
    private long profitRecordId;
    private BigDecimal profitMoney;
    private String profitType;
    private String remark;
    private Long tnWalletId;
    private String bCreateuser;
    private Timestamp bCreatetime;
    private String bLastupdateuser;
    private Timestamp bLastupdatetime;
    private String bTransactionid;
    private Timestamp bDeletetime;
    private String bReferenceorder;
    private String bCurrenttoken;
    private String version;
    private BigDecimal contractPayout;
    private BigDecimal contractGrossProfiti;
    private String profitNumber;
    private BigDecimal payableContract;
    private Long contractType;
    private String cid;
    private BigDecimal netProfit;
    private BigDecimal contractCost;
    private BigDecimal avaliableCost;

    @Id
    @Column(name = "profit_record_id")
    public long getProfitRecordId() {
        return profitRecordId;
    }

    public void setProfitRecordId(long profitRecordId) {
        this.profitRecordId = profitRecordId;
    }

    @Basic
    @Column(name = "profit_money")
    public BigDecimal getProfitMoney() {
        return profitMoney;
    }

    public void setProfitMoney(BigDecimal profitMoney) {
        this.profitMoney = profitMoney;
    }

    @Basic
    @Column(name = "profit_type")
    public String getProfitType() {
        return profitType;
    }

    public void setProfitType(String profitType) {
        this.profitType = profitType;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "tn_wallet_id")
    public Long getTnWalletId() {
        return tnWalletId;
    }

    public void setTnWalletId(Long tnWalletId) {
        this.tnWalletId = tnWalletId;
    }

    @Basic
    @Column(name = "B_CREATEUSER")
    public String getbCreateuser() {
        return bCreateuser;
    }

    public void setbCreateuser(String bCreateuser) {
        this.bCreateuser = bCreateuser;
    }

    @Basic
    @Column(name = "B_CREATETIME")
    public Timestamp getbCreatetime() {
        return bCreatetime;
    }

    public void setbCreatetime(Timestamp bCreatetime) {
        this.bCreatetime = bCreatetime;
    }

    @Basic
    @Column(name = "B_LASTUPDATEUSER")
    public String getbLastupdateuser() {
        return bLastupdateuser;
    }

    public void setbLastupdateuser(String bLastupdateuser) {
        this.bLastupdateuser = bLastupdateuser;
    }

    @Basic
    @Column(name = "B_LASTUPDATETIME")
    public Timestamp getbLastupdatetime() {
        return bLastupdatetime;
    }

    public void setbLastupdatetime(Timestamp bLastupdatetime) {
        this.bLastupdatetime = bLastupdatetime;
    }

    @Basic
    @Column(name = "B_TRANSACTIONID")
    public String getbTransactionid() {
        return bTransactionid;
    }

    public void setbTransactionid(String bTransactionid) {
        this.bTransactionid = bTransactionid;
    }

    @Basic
    @Column(name = "B_DELETETIME")
    public Timestamp getbDeletetime() {
        return bDeletetime;
    }

    public void setbDeletetime(Timestamp bDeletetime) {
        this.bDeletetime = bDeletetime;
    }

    @Basic
    @Column(name = "B_REFERENCEORDER")
    public String getbReferenceorder() {
        return bReferenceorder;
    }

    public void setbReferenceorder(String bReferenceorder) {
        this.bReferenceorder = bReferenceorder;
    }

    @Basic
    @Column(name = "B_CURRENTTOKEN")
    public String getbCurrenttoken() {
        return bCurrenttoken;
    }

    public void setbCurrenttoken(String bCurrenttoken) {
        this.bCurrenttoken = bCurrenttoken;
    }

    @Basic
    @Column(name = "VERSION")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "contract_payout")
    public BigDecimal getContractPayout() {
        return contractPayout;
    }

    public void setContractPayout(BigDecimal contractPayout) {
        this.contractPayout = contractPayout;
    }

    @Basic
    @Column(name = "contract_gross_profiti")
    public BigDecimal getContractGrossProfiti() {
        return contractGrossProfiti;
    }

    public void setContractGrossProfiti(BigDecimal contractGrossProfiti) {
        this.contractGrossProfiti = contractGrossProfiti;
    }

    @Basic
    @Column(name = "profit_number")
    public String getProfitNumber() {
        return profitNumber;
    }

    public void setProfitNumber(String profitNumber) {
        this.profitNumber = profitNumber;
    }

    @Basic
    @Column(name = "payable_contract")
    public BigDecimal getPayableContract() {
        return payableContract;
    }

    public void setPayableContract(BigDecimal payableContract) {
        this.payableContract = payableContract;
    }

    @Basic
    @Column(name = "contract_type")
    public Long getContractType() {
        return contractType;
    }

    public void setContractType(Long contractType) {
        this.contractType = contractType;
    }

    @Basic
    @Column(name = "cid")
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "net_profit")
    public BigDecimal getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }

    @Basic
    @Column(name = "contract_cost")
    public BigDecimal getContractCost() {
        return contractCost;
    }

    public void setContractCost(BigDecimal contractCost) {
        this.contractCost = contractCost;
    }

    @Basic
    @Column(name = "avaliable_cost")
    public BigDecimal getAvaliableCost() {
        return avaliableCost;
    }

    public void setAvaliableCost(BigDecimal avaliableCost) {
        this.avaliableCost = avaliableCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfitRecordEntity that = (ProfitRecordEntity) o;

        if (profitRecordId != that.profitRecordId) return false;
        if (profitMoney != null ? !profitMoney.equals(that.profitMoney) : that.profitMoney != null) return false;
        if (profitType != null ? !profitType.equals(that.profitType) : that.profitType != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (tnWalletId != null ? !tnWalletId.equals(that.tnWalletId) : that.tnWalletId != null) return false;
        if (bCreateuser != null ? !bCreateuser.equals(that.bCreateuser) : that.bCreateuser != null) return false;
        if (bCreatetime != null ? !bCreatetime.equals(that.bCreatetime) : that.bCreatetime != null) return false;
        if (bLastupdateuser != null ? !bLastupdateuser.equals(that.bLastupdateuser) : that.bLastupdateuser != null)
            return false;
        if (bLastupdatetime != null ? !bLastupdatetime.equals(that.bLastupdatetime) : that.bLastupdatetime != null)
            return false;
        if (bTransactionid != null ? !bTransactionid.equals(that.bTransactionid) : that.bTransactionid != null)
            return false;
        if (bDeletetime != null ? !bDeletetime.equals(that.bDeletetime) : that.bDeletetime != null) return false;
        if (bReferenceorder != null ? !bReferenceorder.equals(that.bReferenceorder) : that.bReferenceorder != null)
            return false;
        if (bCurrenttoken != null ? !bCurrenttoken.equals(that.bCurrenttoken) : that.bCurrenttoken != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (contractPayout != null ? !contractPayout.equals(that.contractPayout) : that.contractPayout != null)
            return false;
        if (contractGrossProfiti != null ? !contractGrossProfiti.equals(that.contractGrossProfiti) : that.contractGrossProfiti != null)
            return false;
        if (profitNumber != null ? !profitNumber.equals(that.profitNumber) : that.profitNumber != null) return false;
        if (payableContract != null ? !payableContract.equals(that.payableContract) : that.payableContract != null)
            return false;
        if (contractType != null ? !contractType.equals(that.contractType) : that.contractType != null) return false;
        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (netProfit != null ? !netProfit.equals(that.netProfit) : that.netProfit != null) return false;
        if (contractCost != null ? !contractCost.equals(that.contractCost) : that.contractCost != null) return false;
        if (avaliableCost != null ? !avaliableCost.equals(that.avaliableCost) : that.avaliableCost != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (profitRecordId ^ (profitRecordId >>> 32));
        result = 31 * result + (profitMoney != null ? profitMoney.hashCode() : 0);
        result = 31 * result + (profitType != null ? profitType.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (tnWalletId != null ? tnWalletId.hashCode() : 0);
        result = 31 * result + (bCreateuser != null ? bCreateuser.hashCode() : 0);
        result = 31 * result + (bCreatetime != null ? bCreatetime.hashCode() : 0);
        result = 31 * result + (bLastupdateuser != null ? bLastupdateuser.hashCode() : 0);
        result = 31 * result + (bLastupdatetime != null ? bLastupdatetime.hashCode() : 0);
        result = 31 * result + (bTransactionid != null ? bTransactionid.hashCode() : 0);
        result = 31 * result + (bDeletetime != null ? bDeletetime.hashCode() : 0);
        result = 31 * result + (bReferenceorder != null ? bReferenceorder.hashCode() : 0);
        result = 31 * result + (bCurrenttoken != null ? bCurrenttoken.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (contractPayout != null ? contractPayout.hashCode() : 0);
        result = 31 * result + (contractGrossProfiti != null ? contractGrossProfiti.hashCode() : 0);
        result = 31 * result + (profitNumber != null ? profitNumber.hashCode() : 0);
        result = 31 * result + (payableContract != null ? payableContract.hashCode() : 0);
        result = 31 * result + (contractType != null ? contractType.hashCode() : 0);
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (netProfit != null ? netProfit.hashCode() : 0);
        result = 31 * result + (contractCost != null ? contractCost.hashCode() : 0);
        result = 31 * result + (avaliableCost != null ? avaliableCost.hashCode() : 0);
        return result;
    }
}
