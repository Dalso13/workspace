$(function () {
    document.getElementById("logo").onclick = function () {
        location.href = "/";
    }
})

let searchV  = "";
function clickSpan(s) {
    // location.href = `\${s.innerText}`;
}


const searchBar = $("#searchBar");
const res = $("#res");

searchBar.on("focusout", () => {
    res.css('display', 'none');
})
searchBar.on("focusin", () => {
    if (searchBar.val() !== "") {
        res.css('display', 'inline-block');
    }
})



// 검색 관련단어 이벤트
function searchEvent(e) {
    
    // 포커스가 없을때
    if (res.children("#focusSpan").length <= 0) {
        if (e == 38) {
            res.css('display', 'none');
        } else if (e == 40) {
            res.css('display', 'inline-block');
            res.children("span.clickSpan").first().attr("id","focusSpan");
            searchBar.val(res.children("#focusSpan").text())
        }
        // 포커스가 있을때
    } else {
        let dis = res.children("#focusSpan");

        if (e == 38) {
            if (dis.prevAll(".clickSpan").length == 0) {
                dis.removeAttr("id");
                searchBar.val(searchV);
            } else {
                dis.removeAttr("id");
                dis.prevAll(".clickSpan").first().attr("id","focusSpan");
                searchBar.val(dis.prevAll(".clickSpan").first().text())
            }
        } else if (e == 40) {
            if (dis.nextAll(".clickSpan").length == 0){
                dis.removeAttr("id");
                res.children("span.clickSpan").first().attr("id","focusSpan");
                searchBar.val(res.children("#focusSpan").text());
            } else {
                dis.removeAttr("id");
                dis.nextAll(".clickSpan").first().attr("id","focusSpan");
                searchBar.val(dis.nextAll(".clickSpan").first().text());
            }
        }

    }


}






// 검색단어 매칭
searchBar.on("keyup", function (e) {

    if(e.keyCode == 37 || e.keyCode == 39){
        return;
    }

    if (((e.keyCode == 38 || e.keyCode == 40)
            && res.find("span").text() != " 검색결과가 없습니다 ") && $(this).val() != "") {
            searchEvent(e.keyCode);

            return;


    }
    res.css('display', 'inline-block');
    res.html("");


    let count = 0;
    let countryList = [];
    let semiCountryList = [];
    searchV = $(this).val().replaceAll(" ","");

    if (searchV.length > 0) {
        for (let i = 0; i < countrys.length; i++) {
            let compare = (countrys[i]["country"].replaceAll(" ","")).indexOf(searchV);

            if (compare === 0) {
                countryList.push(i);
            } else if (compare >= 1) {
                semiCountryList.push(i);
            } else if (compare === -1) {
                count++;
            }
        }
    } else if (searchV.length < 1) {
        res.css('display', 'none');
        return;
    }

    if (count == countrys.length) {
        res.html("<span> 검색결과가 없습니다 <span>");
    } else {
        let result = "";
        for (let i = 0; i < countryList.length; i++) {
            result += `<span class="clickSpan" onclick = "clickSpan(this)">${countrys[countryList[i]]["country"]}</span> </br>`;
            if (i == 5) {
                break;
            }
        }
        if (countryList.length < 5) {
            for (let i = 0; i < semiCountryList.length; i++) {
                result += `<span class="clickSpan" onclick = "clickSpan(this)">${countrys[semiCountryList[i]]["country"]}</span> </br>`;
                if (i + countryList.length == 5) {
                    break;
                }
            }
        }
        res.html(result);
    }


})