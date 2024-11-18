async function fetchdata (){
    let data = await fetch('127.0.0.1:8080/api/products')
    return await data.json()
}