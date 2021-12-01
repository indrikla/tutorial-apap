import React from "react";

const SearchBar = (props) => {
    const barStyling = {width: "100%", background: "#F2F1F9", border: "none", padding: "0.5rem"};
    return (
        <input
            style={barStyling}
            type="search"
            placeholder={"Cari barang"}
            onChange={props.handleChange}
        />
    );
}
export default SearchBar;