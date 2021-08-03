async function findDocumentInBox(){
    let div = document.getElementById('look')
    let input = document.getElementById('nameBox')
    let nameBox = input.value

     let reqest = await fetch(`http://localhost:8080/api/v1/info/${nameBox}`,{
            method: "GET",
            headers: {
                "Content-Type": "application/json"
              },

        })

        let responce = await reqest.json();
        if(responce.length == 0){
            alert("Not find  box with this name, try again ")
            return
        }

        addDocumentInTable(responce)

        console.log(responce)
        div.style.display = 'block'

}

function addDocumentInTable(arrays){
    let table = document.getElementById("showDocuments")
    table.innerText = null

    addHeap(table)

    arrays.forEach(element => {
        let tr = document.createElement("tr")
        let id = document.createElement("td")
        let name = document.createElement("td")
        let code = document.createElement("td")

        id.innerText = element.id
        name.innerText = element.name
        code.innerText = element.code

        tr.append(id)
        tr.append(name)
        tr.append(code)

        table.append(tr)
    });
}

function addHeap(table){
    let tr = document.createElement("tr")
    let id = document.createElement("td")
    let name = document.createElement("td")
    let code = document.createElement("td")

    id.innerText = "Id"
    name.innerText = "Name"
    code.innerText = "Code"

    tr.append(id)
    tr.append(name)
    tr.append(code)

    table.append(tr)
}

function cansel(idDiv){
    let div = document.getElementById(idDiv)
    div.style.display = 'none'
    let input = document.getElementById('idDocument')
    input.value = null
}