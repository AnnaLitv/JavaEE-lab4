package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Orders {
    private int idorders;
    private Date date;
    private String adress;

    @Id
    @Column(name = "idorders", nullable = false)
    public int getIdorders() {
        return idorders;
    }

    public void setIdorders(int idorders) {
        this.idorders = idorders;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "adress", nullable = true, length = -1)
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (idorders != orders.idorders) return false;
        if (date != null ? !date.equals(orders.date) : orders.date != null) return false;
        if (adress != null ? !adress.equals(orders.adress) : orders.adress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idorders;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        return result;
    }
}
