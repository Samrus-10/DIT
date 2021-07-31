
async function createDocShow(){
    let div = document.getElementById('create')
    div.style.display = 'block'
}

async function createDocSave(){
    let div = document.getElementById('create')
    let input_name = document.getElementById('newNameDoc') 
    let input_code = document.getElementById('newCodeDoc')       
    let input_name_boxe = document.getElementById('nameBoxDoc')

    let input = document.getElementById('idDocument')
    let idDoc = input.value

     let reqest = await fetch("http://localhost:8080/createNewDoc",{
            method: "POST",
            headers: {
                "Content-Type": "application/json"
              },
            body: JSON.stringify({
                name : input_name.value,
                code: input_code.value,
                box: input_name_boxe.value
            })
        })

        let responce = await reqest.json();

        if(!responce){
            // let div = document.getElementById('look')
            // div.style.display = 'none'
            alert('Not correct name box, try again.')
            return
        }

        console.log(responce)

    div.style.display = 'none'
}

async function findDocument(){
    let div = document.getElementById('look')
    let input_name = document.getElementById('nameDoc')
    let input_code = document.getElementById('codeDoc')
    let input_box = document.getElementById('naemBox')



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
        input_box.value = responce.box

}

async function changeDocName(){
    let input_name = document.getElementById('nameDoc')

    let input = document.getElementById('idDocument')
    let idDoc = input.value

     let reqest = await fetch("http://localhost:8080/changeDocName",{
            method: "POST",
            headers: {
                "Content-Type": "application/json"
              },
            body: JSON.stringify({
                id : idDoc,
                change: input_name.value
            })
        })

        let responce = await reqest.json();

        if(!responce){
            let div = document.getElementById('look')
            div.style.display = 'none'
        }

        console.log(responce)
        alert("change success")
}

async function changeDocCode(){
    let input_code = document.getElementById('codeDoc')

    let input = document.getElementById('idDocument')
    let idDoc = input.value

     let reqest = await fetch("http://localhost:8080/changeDocCode",{
            method: "POST",
            headers: {
                "Content-Type": "application/json"
              },
            body: JSON.stringify({
                id : idDoc,
                change: input_code.value
            })
        })

        let responce = await reqest.json();

        if(!responce){
            let div = document.getElementById('look')
            div.style.display = 'none'
        }

        console.log(responce)
        alert("change success")
}

async function changeDocBox(){
    let input_code = document.getElementById('naemBox')

    let input = document.getElementById('idDocument')
    let idDoc = input.value

     let reqest = await fetch("http://localhost:8080/changeDocBox",{
            method: "POST",
            headers: {
                "Content-Type": "application/json"
              },
            body: JSON.stringify({
                id : idDoc,
                change: input_code.value
            })
        })

        let responce = await reqest.json();

        if(!responce){
            // let div = document.getElementById('look')
            // div.style.display = 'none'
            alert("not correct name box, try again")
            return
        }
    
        console.log(responce)
        alert("change success")
}

async function deleteDocument(){
    let div = document.getElementById('look')
    let input = document.getElementById('idDocument')
    let idDoc = input.value

     let reqest = await fetch("http://localhost:8080/deleteDocById",{
            method: "POST",
            headers: {
                "Content-Type": "application/json"
              },
            body: JSON.stringify({
                id : idDoc
            })
        })
    
        let responce = await reqest.json();
        if(!responce){
            alert("erroe")
            return
        }
    
        console.log(responce)
        
    div.style.display = 'none'
    input.value = null
}

function cansel(idDiv){
    let div = document.getElementById(idDiv)
    div.style.display = 'none'
    let input = document.getElementById('idDocument')
    input.value = null
}


