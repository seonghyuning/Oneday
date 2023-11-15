function search() {
        let onedayName = document.getElementById("oneday_name").value;
        let form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", "/board/search");
        let input = document.createElement("input");
        input.setAttribute("type", "hidden");
        input.setAttribute("name", "onedayName");
        input.setAttribute("value", onedayName);
        form.appendChild(input);
        document.body.appendChild(form);
        form.submit();
    }
function baking() {
    location.href =/*[[@{/category(page=1)}]]*/"";
}
function perfume() {
    location.href =/*[[@{/category(page=2)}]]*/"";
}
function drawing() {
    location.href =/*[[@{/category(page=3)}]]*/"";
}
function dance() {
    location.href =/*[[@{/category(page=4)}]]*/"";
}
function date() {
    location.href =/*[[@{/category(page=5)}]]*/"";
}