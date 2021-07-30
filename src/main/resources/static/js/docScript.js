
async function createDocShow(){
    let div = document.getElementById('create')
    div.style.display = 'block'
}

async function createDocSave(){
    let div = document.getElementById('create')
    div.style.display = 'none'
}

async function findDocument(){
    let div = document.getElementById('look')
    let input_name = document.getElementById('nameDoc')
    let input_code = document.getElementById('codeDoc')



    let input = document.getElementById('idDocument')
    let idDoc = input.value

     let reqest = await fetch("http://localhost:8080/findDocById",{
            method: "POST",
            headers: {
                "Content-Type": "application/json"
              },
            body: JSON.stringify({
                id : idDoc
            })
        })

        let responce = await reqest.json();
        if(responce == null){
            alert("Not find  document with this id, try again ")
            return
        }

        console.log(responce)
        div.style.display = 'block'
        input_name.value = responce.name
        input_code.value = responce.code

}

async function changeDocName(){
    alert('changeDocName')
}

async function changeDocCode(){
    alert('changeDocCode')
}

async function deleteDocument(){
    let div = document.getElementById('look')
    div.style.display = 'none'
    let input = document.getElementById('idDocument')
    input.value = null
}

function cansel(idDiv){
    let div = document.getElementById(idDiv)
    div.style.display = 'none'
    let input = document.getElementById('idDocument')
    input.value = null
}


