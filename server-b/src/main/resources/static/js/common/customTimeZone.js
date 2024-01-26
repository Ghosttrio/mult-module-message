// const tdListElement = document.getElementsByClassName('date');
// for(const td of tdListElement){
//     console.log("TD innerHTML: "+ td.innerHTML);
//     console.log("TD value: "+ td.value);
//     if(td.innerHTML) {
//         var utc = moment.tz(td.innerHTML, "UTC");
//         console.log("utc: "+ utc);
//         td.innerHTML = utc.clone().tz("Asia/Seoul").format('yyyy-MM-DD HH:mm');
//     } else {
//         var utc = moment.tz(td.value, "UTC");
//         td.value = utc.clone().tz("Asia/Seoul").format('yyyy-MM-DD HH:mm');
//     }
// }