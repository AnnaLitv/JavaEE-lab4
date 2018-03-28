package src;


import entities.Orders;
import entities.User;

import javax.persistence.*;

@Entity
@Table(name = "user_orders", schema = "tsukat", catalog = "")
public class UserOrders {
    private int idUserOrders;
    private User userByIdcustomer;
    private Orders ordersByIdorderCust;

    @Id
    @Column(name = "id_user_orders", nullable = false)
    public int getIdUserOrders() {
        return idUserOrders;
    }

    public void setIdUserOrders(int idUserOrders) {
        this.idUserOrders = idUserOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserOrders that = (UserOrders) o;

        if (idUserOrders != that.idUserOrders) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idUserOrders;
    }

    @ManyToOne
    @JoinColumn(name = "idcustomer", referencedColumnName = "idUser", nullable = false)
    public User getUserByIdcustomer() {
        return userByIdcustomer;
    }

    public void setUserByIdcustomer(User userByIdcustomer) {
        this.userByIdcustomer = userByIdcustomer;
    }

    @ManyToOne
    @JoinColumn(name = "idorder_cust", referencedColumnName = "idorders", nullable = false)
    public Orders getOrdersByIdorderCust() {
        return ordersByIdorderCust;
    }

    public void setOrdersByIdorderCust(Orders ordersByIdorderCust) {
        this.ordersByIdorderCust = ordersByIdorderCust;
    }
}
