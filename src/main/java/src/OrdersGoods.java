package src;

import entities.Goods;
import entities.Orders;

import javax.persistence.*;

@Entity
@Table(name = "orders_goods", schema = "tsukat")
public class OrdersGoods {
    private int idOrdersGoods;
    private Goods goodsByIdgoods;
    private Orders ordersByIdorder;

    @Id
    @Column(name = "id_orders_goods", nullable = false)
    public int getIdOrdersGoods() {
        return idOrdersGoods;
    }

    public void setIdOrdersGoods(int idOrdersGoods) {
        this.idOrdersGoods = idOrdersGoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersGoods that = (OrdersGoods) o;

        if (idOrdersGoods != that.idOrdersGoods) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idOrdersGoods;
    }

    @ManyToOne
    @JoinColumn(name = "idgoods", referencedColumnName = "idgoods", nullable = false)
    public Goods getGoodsByIdgoods() {
        return goodsByIdgoods;
    }

    public void setGoodsByIdgoods(Goods goodsByIdgoods) {
        this.goodsByIdgoods = goodsByIdgoods;
    }

    @ManyToOne
    @JoinColumn(name = "idorder", referencedColumnName = "idorders", nullable = false)
    public Orders getOrdersByIdorder() {
        return ordersByIdorder;
    }

    public void setOrdersByIdorder(Orders ordersByIdorder) {
        this.ordersByIdorder = ordersByIdorder;
    }
}
