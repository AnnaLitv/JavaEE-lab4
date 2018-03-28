package entities;

import javax.persistence.*;

@Entity
public class Goods {
    private int idgoods;
    private int code;
    private String name;
    private int weight;
    private int price;
    private int quantity;
    private String img;
    private Category categoryByIdcategory;

    @Transient
    private boolean editable;

    public Goods(){}
    public Goods(String name, Integer code, Integer weight, Integer price, Integer quantity, Category idCategory, String img) {
        this.setName(name);
        this.setCode(code);
        this.setWeight(weight);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setImg(img);
        this.setCategoryByIdcategory(idCategory);
    }

    @Id
    @Column(name = "idgoods", nullable = false)
    public int getIdgoods() {
        return idgoods;
    }

    public void setIdgoods(int idgoods) {
        this.idgoods = idgoods;
    }

    @Basic
    @Column(name = "code", nullable = false)
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 2000)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "weight", nullable = false, length = 45)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "price", nullable = false, length = 45)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "quantity", nullable = false, length = 45)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "img", nullable = true, length = -1)
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (idgoods != goods.idgoods) return false;
        if (code != goods.code) return false;
        if (weight != goods.weight) return false;
        if (price != goods.price) return false;
        if (quantity != goods.quantity) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
        if (img != null ? !img.equals(goods.img) : goods.img != null) return false;
        return categoryByIdcategory != null ? categoryByIdcategory.equals(goods.categoryByIdcategory) : goods.categoryByIdcategory == null;
    }

    @Override
    public int hashCode() {
        int result = idgoods;
        result = 31 * result + code;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + weight;
        result = 31 * result + price;
        result = 31 * result + quantity;
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (categoryByIdcategory != null ? categoryByIdcategory.hashCode() : 0);
        return result;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcategory", referencedColumnName = "idcategory", nullable = false)
    public Category getCategoryByIdcategory() {
        return categoryByIdcategory;
    }

    public void setCategoryByIdcategory(Category categoryByIdcategory) {
        this.categoryByIdcategory = categoryByIdcategory;
    }

    @Transient
    public boolean isEditable() {
        return editable;
    }

    @Transient
    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}
