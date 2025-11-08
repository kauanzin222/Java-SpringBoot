
//Masks 
$('#priceInput').mask("000.000.000.000.000,00", { reverse: true });

var products = [];

var categories = [];

//OnLoad 
loadCategories();
loadProducts();

//Load all categories
function loadCategories() {
    $.ajax({
        url: "http://localhost:8080/Categories",
        type: "GET",
        async: false,
        success: (response) => {

            categories = response;

            for (let category of categories) {
                $("#selectCategory").append(`<option value=${category.id}>${category.name}</option>`)
            }
        }
    })
}

//Load all products
function loadProducts() {

    $.getJSON("http://localhost:8080/Products", (response) => {
        products = response;

        for (let prod of products) {
            addNewRow(prod);
        }
    })

}

//Save a product
function save() {

    // Limpa a máscara do preço e converte para número
    let priceNoFormat = document.getElementById("priceInput").value;
    priceNoFormat = parseFloat(priceNoFormat.replace(/\./g, '').replace(',', '.'));

    var prod = {
        name: document.getElementById("nameInput").value,
        description: document.getElementById("descInput").value,
        price: priceNoFormat,
        idCategory: parseInt(document.getElementById("selectCategory").value),
        promotion: document.getElementById("checkboxPromotion").checked,
        newProduct: document.getElementById("checkboxNewProduct").checked
    };

    $.ajax({
        url: "http://localhost:8080/Products",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(prod),
        success: (product) => {

            addNewRow(product);

            //Armazena o novo produto no array
            products.push(product);

            //Limpa os dados do forms
            document.getElementById("formProduct").reset();
        }
    })
}

//Add new row
function addNewRow(prod) {
    var table = document.getElementById("productsTable");

    var newRow = table.insertRow();

    //Insert product id 
    addNodeRow(newRow, prod.id);

    //Insert product name 
    addNodeRow(newRow, prod.name);

    //Insert  product description
    var descNode = document.createTextNode(prod.description);

    var cell = newRow.insertCell();
    cell.className = "d-none d-md-table-cell";

    cell.appendChild(descNode);

    //Insert product price
    var formatter = new Intl.NumberFormat("pt-BR", {
        style: "currency",
        currency: "BRL"
    });

    addNodeRow(newRow, formatter.format(prod.price));

    //Insert  product category
    addNodeRow(newRow, categories[prod.idCategory - 1].name);

    //Insert product options 
    var options = "";

    if (prod.promotion)
        options = "<span class='badge bg-success me-1'>P</span>";
    if (prod.newProduct)
        options += "<span class='badge bg-primary me-1'>L</span>";

    cell = newRow.insertCell();
    cell.className = "d-none d-md-table-cell";
    cell.innerHTML = options;
}

function addNodeRow(newRow, dado) {
    const dadoNode = document.createTextNode(dado);

    addCell(newRow, dadoNode);
}

function addCell(newRow, node) {
    newRow.insertCell().appendChild(node);
}