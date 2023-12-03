class Board{
    #nameStr;
    #name;
    #set;

    constructor(name) {
        this.#nameStr= name;
        this.#name = document.querySelector("#"+name);
        this.#set = {};
        this.init()
    }
    init(){
        if(!this.#name){
            alert("삽입할 태그를 지정하세요"); 
        }
        this.#name.className = "table table-bordered boardCol"
        this.#name.innerHTML = ""
        this.#name.insertAdjacentHTML("beforeend", `<tr class = '${this.#nameStr}ColHead' id = '${this.#nameStr}ColHead' >
                                                   </tr>`);
        this.#name.insertAdjacentHTML("beforeend", `<tbody class = '${this.#nameStr}ColBody' id ="${this.#nameStr}ColBody" >
                                                    </tbody>`);
    }

    setBoard(set){
        if(typeof(set) !== "object"){
            console.error("setBoard paramType nor Object")
            return;
        };

        this.#set = set;
        if(!this.#set.page){
            this.#set.page = 1;
        }
        if(!this.#set.countRow){
            this.#set.countRow = 10;
        }


    }

    makeCol(){
      const col = this.#set.col
      let colTh = "";
      col.forEach(colObj =>{
          colTh += `<th class="col boardTh">${colObj.name}</th>`
      })
      document.querySelector(`#${this.#nameStr}ColHead`).insertAdjacentHTML("beforeend",colTh);
    }

    callBoard(url,method,headers){


        this.#checkSet()

        if(!url){
            console.error("Not Found URL By Board Fetch")
            return
        }
        url += "?page"+this.#set.page+"&countRow"+this.#set.countRow;

        method = method ? method : "GET";

        headers = headers ? headers : {
                                        'Content-Type': 'application/json'
                                      };

        fetch(url,{
            method 
            ,headers
        })
        .then(response =>  {return response.json()} )
        .then(data =>{

            this.#write(data);

        }).catch(error => ()=>{
            alert("Error");
            console.error("error");
        })
    }
    #write(data) {
        const col = this.#set.col
        const tbody = document.querySelector(`#${this.#nameStr}ColBody`)
        tbody.innerHTML="";

        let tagStr = "";
        data.forEach(obj =>{
            tagStr += "<tr>";
            col.forEach(colObj =>{
                tagStr += `<td>${obj[colObj.name]}</td>`;
            });
            tagStr += "</tr>"
            tagStr += "</tr>"
        });

        tbody.insertAdjacentHTML("beforeend", tagStr);


        data.forEach(obj =>{
            Object.entries(obj).forEach(([key,val]) => {
            
                console.log(key,val);

            })
        })
        
    }

    #checkSet(){

    }

}




