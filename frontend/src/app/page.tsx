"use client"

import Carregando from "@/components/Carregando";
import ProductCard from "@/components/productCard";
import { useEffect, useState } from "react";

export default function Home() {
  const [products, setProducts] = useState<Product[]>([]);

  async function fetchdata (){
    let data = await fetch('http://127.0.0.1:8080/api/products')
    setProducts(await data.json())
  }

  useEffect(() => {
    fetchdata()
  },[]);

  console.log(products)
  return (
    <div>
        {products.length > 0 ?
          products.map((product: Product) =>
          <ProductCard key={product.id}
            nome={product.nome}
            img={product.img}
            preco={product.preco}
            />
        ): <Carregando/>
        }
    </div>
  );
}
