"use server"
import Carregando from "@/components/Carregando";
import ProductCard from "@/components/productCard";

export default async function Home() {
  const response = await fetch("http://localhost:8080/api/products")
  const products:Products[] = await response.json().catch(error => console.log(error))
  console.log(products)
  return (
    <div className="flex mt-4 place-content-evenly flex-wrap">
        {products.length > 0 ?
          products.map((product: Products) =>
          <ProductCard data={product}/>
        ): <Carregando/>
        }
    </div>
  );
}
