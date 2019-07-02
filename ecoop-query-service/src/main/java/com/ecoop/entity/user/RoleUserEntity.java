package com.ecoop.entity.user;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName RoleUserEntity
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 19:39
 * @Version 1.0
 **/
@Entity
@Table(name = "role_user", schema = "zsuser_mv", catalog = "")
public class RoleUserEntity {
    private long roleUserId;
    private String roleName;
    private long isCanDelete;
    private String description;
    private String bCreateuser;
    private Timestamp bCreatetime;
    private String bLastupdateuser;
    private Timestamp bLastupdatetime;
    private String bTransactionid;
    private Timestamp bDeletetime;
    private Long userId;

    @Id
    @Column(name = "role_user_id")
    public long getRoleUserId() {
        return roleUserId;
    }

    public void setRoleUserId(long roleUserId) {
        this.roleUserId = roleUserId;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "is_can_delete")
    public long getIsCanDelete() {
        return isCanDelete;
    }

    public void setIsCanDelete(long isCanDelete) {
        this.isCanDelete = isCanDelete;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleUserEntity that = (RoleUserEntity) o;

        if (roleUserId != that.roleUserId) return false;
        if (isCanDelete != that.isCanDelete) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (bCreateuser != null ? !bCreateuser.equals(that.bCreateuser) : that.bCreateuser != null) return false;
        if (bCreatetime != null ? !bCreatetime.equals(that.bCreatetime) : that.bCreatetime != null) return false;
        if (bLastupdateuser != null ? !bLastupdateuser.equals(that.bLastupdateuser) : that.bLastupdateuser != null)
            return false;
        if (bLastupdatetime != null ? !bLastupdatetime.equals(that.bLastupdatetime) : that.bLastupdatetime != null)
            return false;
        if (bTransactionid != null ? !bTransactionid.equals(that.bTransactionid) : that.bTransactionid != null)
            return false;
        if (bDeletetime != null ? !bDeletetime.equals(that.bDeletetime) : that.bDeletetime != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (roleUserId ^ (roleUserId >>> 32));
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (int) (isCanDelete ^ (isCanDelete >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (bCreateuser != null ? bCreateuser.hashCode() : 0);
        result = 31 * result + (bCreatetime != null ? bCreatetime.hashCode() : 0);
        result = 31 * result + (bLastupdateuser != null ? bLastupdateuser.hashCode() : 0);
        result = 31 * result + (bLastupdatetime != null ? bLastupdatetime.hashCode() : 0);
        result = 31 * result + (bTransactionid != null ? bTransactionid.hashCode() : 0);
        result = 31 * result + (bDeletetime != null ? bDeletetime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
