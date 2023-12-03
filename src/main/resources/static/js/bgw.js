const bgw = {}
bgw.$ = document.querySelectorAll.bind(document);
bgw._= document.querySelector.bind(document);
bgw.input = (dom,fn)=>{
    dom.addEventListener("input",fn)
}

bgw.click = (dom,fn)=>{
    dom.addEventListener("click",fn);
}
bgw.domain = ()=>{
     return "//"+window.location.host;
}
bgw.url = ()=>{
    return window.location.href;
}
bgw.path = ()=>{
    return window.location.pathname;
}

