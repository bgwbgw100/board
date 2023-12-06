class Board{
    #nameStr;
    #name;
    #set;
    dataList = [];
    rowClickEvent;
    #classThis = this;
    constructor(name) {
        this.#nameStr= name;
        this.#name = document.querySelector("#"+name);
        this.#set = {};
        this.#init()
    }
    #init(){
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
            this.#addEvent();
        }).catch(error => ()=>{
            alert("Error");
            console.error("error");
        })
    }

    escapeHtml(str){
        return str.replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#039;');
    }
    #write(data) {
        const col = this.#set.col
        const tbody = document.querySelector(`#${this.#nameStr}ColBody`)
        tbody.innerHTML="";

        let tagStr = "";
        let idx = 0;
        data.forEach(obj =>{
            tagStr += `<tr class='boardTr' data-idx ='${idx}'>`;
            col.forEach(colObj =>{
                let str  = obj[colObj.name] +"";
                tagStr += `<td>${this.escapeHtml(str)}</td>`;
            });
            tagStr += "</tr>"
            this.dataList.push(obj);
            idx += 1;
        });

        tbody.insertAdjacentHTML("beforeend", tagStr);
    }

    #addEvent(){
        let tr =  document.querySelectorAll(".boardTr");
        for (const trElement of tr) {
            let idxStr = trElement.dataset.idx;
            let idx = Number(idxStr);

            trElement.addEventListener( "click",(event)=>{

                let tag = event.currentTarget;
                if(typeof(this.rowClickEvent) != "function") return;

                this.rowClickEvent(this.dataList[Number(idx)],tag)
            })
        }
    }



    #checkSet(){

    }

}




