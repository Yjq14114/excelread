package objclass;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ���� on 2016/2/22.
 */
public class EmployeeEntity implements Serializable {
    private java.lang.Long id;
    //fields
    private java.lang.Long eid;//Ա��ID
    private java.lang.String certificatetype;//֤�����//�ֵ�
    private java.lang.String certificatelevel;//֤��ȼ�
    private java.lang.String ertificatedep;//��֤����
    private java.util.Date ertificatebegindate;//�䷢ʱ��//ʱ��
    private java.util.Date ertificateenddate;//֤����Ч��//ʱ��
    private java.lang.String ertificatenumber;//֤����
    private java.lang.String attach;//֤��ɨ���//�ļ�
    private java.lang.String memo;//��ע

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
