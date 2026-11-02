export default function ProductSearch({ value, onSearchChange }) {
    return (
        <div className="searh-box">
            <label htmlFor="product-search">Pesquisar produto</label>
            <input type="search" id="product-search"
            placeholder="Digite o nome do produto"
            value={value}
            onChange={(event) => onSearchChange(event.target.value)} />
        </div>
    )
}