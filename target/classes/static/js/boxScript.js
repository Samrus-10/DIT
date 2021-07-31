
async function createBoxShow(){
    let div = document.getElementById('create')
    div.style.display = 'block'
}

async function createBoxSave(){
    let div = document.getElementById('create')
    let input_name = document.getElementById('newNameBox')
    let input_code = document.getElementById('newCodeBox')

    let input = document.getElementById('idBox')
    let idDoc = input.value

     let reqest = await fetch("http://localhost:8080/createNewBox",{
            method: "POST",
            headers: {
                "Content-Type": "application/json"
              },
            body: JSON.stringify({
                name : input_name.value,
                code: input_code.value
            })
        })

        let responce = await reqest.json();

        if(!responce){
            let div = document.getElementById('look')
            div.style.display = 'none'
        }

        console.log(responce)

    div.style.display = 'none'
}

async function findBox(){
    let div = document.getElementById('look')
    let input_name = document.getElementById('nameBox')
    let input_code = document.getElementById('codeBox')



    let input = document.getElementById('idBox')
    let idDoc = input.value

     let reqest = await fetch("http://localhost:8080/findBoxById",{
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
            alert("Not find  box with this id, try again ")
            return
        }

        console.log(responce)
        div.style.display = 'block'
        input_name.value = responce.name
        input_code.value = responce.code

}

async function changeBoxName(){
    let input_name = document.getElementById('nameBox')

    let input = document.getElementById('idBox')
    let idDoc = input.value

     let reqest = await fetch("http://localhost:8080/changeBoxName",{
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

async function changeBoxCode(){
    let input_code = document.getElementById('codeBox')

    let input = document.getElementById('idBox')
    let idDoc = input.value

     let reqest = await fetch("http://localhost:8080/changeBoxCode",{
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

async function deleteBox(){
    let div = document.getElementById('look')
    let input = document.getElementById('idBox')
    let idDoc = input.value

     let reqest = await fetch("http://localhost:8080/deleteBoxById",{
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


