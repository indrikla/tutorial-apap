import React, { useState, useRef } from "react";
import Button from "../../components/button";
import APIConfig from "../../api/APIConfig";
import classes from "./styles.module.css";
import { Hidden } from "@material-ui/core";

const Item = (props) => {
    const { id, title, price, description, category, quantity, handleDelete, handleEdit} = props;
    const [addToCart, setAddToCart] = useState(false);
    const [quantityInput, setQuantityInput] = useState(0);
    const nameForm = useRef(null)

    function handleDeleteItem() {
        try {
            APIConfig.delete(`/item/${id}`);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    function handleEditItem(item) {
        // this.setState({
        //     isEdit: true,
        //     title: item.title,
        //     price: item.price,
        //     description: item.description,
        //     category: item.category,
        //     quantity: item.quantity,
        // });
    }

    function handleAddToCartItem(quantityInput) {
        console.log(quantity)
        console.log(quantityInput)
        if (quantityInput > quantity) {
            alert("Stock tidak cukup!");
            return ;
        }
        setAddToCart(!addToCart)
        try {
            const data = {
                id: this.state.id,
                quantity: this.state.quantityInput
            };
            console.log("masuk sini")
            APIConfig.post("/cart", data);
            this.setState({
                id: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>
            <div>
                <Button action={handleEditItem}>
                        Edit
                </Button>
                <Button action={handleDeleteItem}>
                        Delete
                </Button>
            </div>
            <div>
                <form ref={nameForm}>
                    <input 
                        type="hidden"
                        value={id}
                        name="id"
                    />
                    <input
                        className={classes.textField}
                        type="number"
                        placeholder="quantity"
                        name="quantityInput"
                        onChange={(event) => setQuantityInput(event.target.value)}
                    />
                    <Button action={() => handleAddToCartItem(id, quantityInput)}>
                        Add to Cart
                    </Button>
                </form>
            </div>
        </div>
    );
};
export default Item;
