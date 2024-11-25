"use client"

import axios from "axios";
import { ChangeEvent, useState } from "react";

type UploadStatus = 'idle' | 'uploading' | 'success' | 'error';

export default function FileUpload(){
    const [file, setFile] = useState<File | null>(null);
    const [status, setStatus] = useState<UploadStatus>('idle')
    
    function handleFileChange(e: ChangeEvent<HTMLInputElement>){
        if(e.target.files){
            setFile(e.target.files[0])
        }
    }

    async function handleFileUpload(){
        
        if(!file) return;

        setStatus('uploading');

        const formData = new FormData()
        formData.append('file', file)

        try{
            await axios.post('http://127.0.0.1:8080/api/products/upload', formData,{
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
            setStatus('success') 
        }catch {
            setStatus('error')
        };
    }

    return <>
    <form onSubmit={handleFileUpload}>
    <label className="block mb-2 text-sm font-medium text-gray-900 dark:text-white" htmlFor="file_input">Upload file</label>
    <input className="block w-full text-sm text-gray-900 border border-gray-300 rounded-lg cursor-pointer bg-gray-50 dark:text-gray-400 focus:outline-none dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400" 
    id="file_input" type="file" onChange={handleFileChange}/>
    {file && status !== 'uploading' && 
            <button  className="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-100 font-medium rounded-full text-sm px-5 py-2.5 me-2 mb-2 dark:bg-gray-800 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700"
            type="submit">Upload</button>
        }
    </form>
        {file && (
            <div className="mb-4 text-sm">
                <p>{file?.name}</p>
                <p>{(file?.size / 1024).toFixed(2)}KB</p>
                <p>{file?.type}</p>
            </div>
        )}
    </>
}