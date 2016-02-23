package objclass;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 佳琦 on 2016/2/22.
 */
public class EmployeeEntity implements Serializable {
    private java.lang.Long id;
    //fields
    private java.lang.Long eid;//员工ID
    private java.lang.String certificatetype;//证书类别//字典
    private java.lang.String certificatelevel;//证书等级
    private java.lang.String ertificatedep;//发证机关
    private java.util.Date ertificatebegindate;//颁发时间//时间
    private java.util.Date ertificateenddate;//证书有效期//时间
    private java.lang.String ertificatenumber;//证书编号
    private java.lang.String attach;//证书扫描件//文件
    private java.lang.String memo;//备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getCertificatetype() {
        return certificatetype;
    }

    public void setCertificatetype(String certificatetype) {
        this.certificatetype = certificatetype;
    }

    public String getCertificatelevel() {
        return certificatelevel;
    }

    public void setCertificatelevel(String certificatelevel) {
        this.certificatelevel = certificatelevel;
    }

    public String getErtificatedep() {
        return ertificatedep;
    }

    public void setErtificatedep(String ertificatedep) {
        this.ertificatedep = ertificatedep;
    }

    public Date getErtificatebegindate() {
        return ertificatebegindate;
    }

    public void setErtificatebegindate(Date ertificatebegindate) {
        this.ertificatebegindate = ertificatebegindate;
    }

    public Date getErtificateenddate() {
        return ertificateenddate;
    }

    public void setErtificateenddate(Date ertificateenddate) {
        this.ertificateenddate = ertificateenddate;
    }

    public String getErtificatenumber() {
        return ertificatenumber;
    }

    public void setErtificatenumber(String ertificatenumber) {
        this.ertificatenumber = ertificatenumber;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
