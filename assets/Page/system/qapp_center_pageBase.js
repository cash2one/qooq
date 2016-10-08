(function(a){var b={},e=function(g,h,i){this.id=g;this.deps=h||[];this.factory=i;this.exports=null},c=function(k){var h,i,j=[],g=b[k],l=0;if(!g){return null}if(g.exports){return g.exports}h=g.factory;typeof h=="function"?(g.deps.forEach(function(m){j.push(c(m))}),i=h.apply(g,j.length?j:[d,g.exports={},g])):i=h;g.exports=i||g.exports;return g.exports},f=function(h,g,i){var j;i==void 0&&(i=g,g=null);g=g?[].concat(g):[];j=new e(h,g,i);b[h]=j;return h},d=function(g){var h=[];g=[].concat(g);g.forEach(function(i){h[i]=c(i)});return g.length==1?h[g[0]]:h};a.modules=b,a.require=d,a.define=f})(window);define("ReportQueue",function(){var a={valueStat:[],valueStatV4:[],stringReport:[],add:function(e,b){e+="";switch(e){case"valueStat":var c=require("ValueStat");c?c.report.apply(c,b):this.valueStat.push(b);break;case"valueStatV4":var d=require("ValueStatV4");d?d.report.apply(d,b):this.valueStatV4.push(b);break;case"stringReport":var f=require("M");c?f.stringReport.apply(f,b):this.stringReport.push(b);break}},send:function(){var b=require("M"),c=require("ValueStat"),d=require("ValueStatV4");a.stringReport.forEach(function(e){b.stringReport.apply(b,e)});a.stringReport=[];a.valueStat.forEach(function(e){c.report.apply(c,e)});a.valueStat=[];a.valueStatV4.forEach(function(e){d.report.apply(d,e)});a.ValueStatV4=[]}};return a});define("LocalStorage",function(c,b){var a=function(){try{if(!!window.localStorage){var d=Math.random();localStorage.setItem("__test__",d);return d==localStorage.getItem("__test__")}return false}catch(f){return false}}();b.support=a;b.set=function(d,f){try{a&&localStorage.setItem(d,f)}catch(g){}};b.get=function(d){try{return a&&localStorage.getItem(d)||""}catch(f){return""}};b.del=function(d){try{a&&localStorage.removeItem(d)}catch(f){}};b.clear=function(){try{a&&localStorage.clear();a&&localStorage.setItem("clearsid",1)}catch(d){}}});define("R",function(){var d=require("Merge"),b=/QQ\/([\d.]+)/.exec(navigator.userAgent);b&&(b=b[1]);var a={isRender:false,qStr:"",modifiedSubJsVer:"",localSubJsVer:"",clearLocalStorage:false,showWelcomePage:false,QQVer:b,hasQQDomain:/\.qq\.com$/.test(location.hostname),"$":function(e){return document.querySelector(e)},checked:false,check:function(){if(!a.checked){var e=require("LocalStorage"),f="5.0.11.22",g=e.get("JSVersion")||"",h="1",i=e.get("PageVersion")||"",k=a.modifiedSubJsVer=parseInt(f.split(".")[3])||0,j=a.localSubJsVer=parseInt(g.split(".")[3])||0;(i&&h!=i||j<4||j>k)&&(e.clear(),d.reset(),a.clearLocalStorage=true);e.set("JSVersion",f,true);e.set("PageVersion",h,true);var l=parseInt("111")+(f==g?0:g?1:2);require("ReportQueue").add("valueStat",["350596",1,l,{reportRate:f==g?10:1}]);a.checked=true}},getParam:function(f,g){var h=new RegExp("[?#&]"+f+"=([^&#]*)","i"),e=h.exec(g||window.location.href);return decodeURIComponent(e?e[1]:"")},render:function(k,f,h,l,i){a.check();var j=require("LocalStorage"),m=window.agentData&&agentData.uin||j.get("uin"),e=j.get(k)||l||"",g=f&&a.$(f);e&&g?(g.innerHTML=e,h&&h.call(null,g,e)):i&&i.call(null,f,e);return a},set:function(f,g,h){a.check();var e=require("LocalStorage"),i=window.agentData&&agentData.uin||e.get("uin");e.set(f,g);return a},show:function(f){var e=a.$(f);e&&(e.style.display="");return a},loadScript:function(e,f){e=[].concat(e),count=0,load=function(h){var g=document.createElement("script");g.onload=cb;g.src=h;document.body.appendChild(g)},cb=function(){count++;count==e.length&&f&&f.call(null)},e.forEach(function(g){load(g)});return}};a.uin=a.getParam("uin");a.sid=a.getParam("sid");var c=a.getParam("mobileInfo");c&&(a.mobileInfo=JSON.parse(c));return a});define("TextDiff",function(){var a=function(e,c){c=c.slice(0);var d=[],b;while(b=c.shift()){typeof b=="string"?d.push(b):d.push(e.substr(b[0],b[1]))}return d.join("")};return{patch:a}});define("Hash",function(){var a=function(d){var b=5381;for(var c=0,e=d.length;c<e;++c){b+=(b<<5)+d.charCodeAt(c)}return b&0x7fffffff};return{DJB:a}});define("Merge",function(){var b=require("LocalStorage"),d=require("TextDiff"),c=require("Hash"),a={agentVer:"11",sceneKey:"",versionKey:"MERGE_RESROUCE_VERSION",resource:{},version:{},updateFlag:{},effectFlag:{},map:{},reportKey:{common:0,home:1,search:2,detail:3},reset:function(){this.resource={};this.version={};this.updateFlag={};this.effectFlag={};this.map={}},applyPatch:function(f,g){var h=false,j=Date.now();try{g=JSON.parse(g);var m=this.map[f],l=d.patch(m.data,g.data);if(c.DJB(l)==g.token){var i={version:g.version,token:g.token,data:l};b.set(f,JSON.stringify(i));this.map[f]=i;this.version[f]=i.version;this.updateFlag[f]=i.version;var k=/common/.test(f)?"common":a.sceneKey;!a.resource[k]&&(a.resource[k]={});a.resource[k][f]=i.version;h=true}else{delete this.map[f];delete this.version[f];b.del(f)}}catch(o){}j=Date.now()-j;var n=[require("R").QQVer*10,a.reportKey[a.sceneKey]||0,"10",h?0:1].join("");require("ReportQueue").add("valueStat",["320710",h?1:2,n,{reportRate:h?10:1,duration:j}]);return h},fullUpdate:function(f,i){try{var g=JSON.parse(i);if(g.version){this.map[f]=g;this.version[f]=g.version;this.updateFlag[f]=g.version;b.set(f,i);var h=/common/.test(f)?"common":a.sceneKey;!a.resource[h]&&(a.resource[h]={});a.resource[h][f]=g.version;return true}}catch(j){}return false},update:function(j){var e,g=j.full,h=false,f=false;if(g){for(e in g){f=this.fullUpdate(e,g[e]);f&&(h=true)}}var i=j.patch;if(i){for(e in i){f=this.applyPatch(e,i[e]);f&&(h=true)}}for(var k in this.resource){b.set("resource_sence_"+k,JSON.stringify(this.resource[k]))}b.set("resource_agentversion",this.agentVer);return h},effect:function(j,h,l){if(!this.resource[this.sceneKey]){return}var f=[];for(var i in this.map){if(i.indexOf(j)>-1){var k=this.map[i];i.indexOf("common")>-1?f.unshift(k.data):f.push(k.data)}}f=f.join(";");if(!f){return false}switch(j){case"js":try{eval(f)}catch(m){}h&&h.call(null);break;case"css":var g=document.querySelector(".resource_css");!g&&(g=document.createElement("style"),g.type="text/css",g.className="resource_css",document.getElementsByTagName("head")[0].appendChild(g));f&&(g.textContent=f);h&&h.call(null);break}},unload:function(){return},getResourceDetail:function(j){var i=b.get("resource_sence_"+j);i=i?JSON.parse(i):{};var h=true,k=Date.now(),l=0;for(var f in i){try{var g=b.get(f);g&&(g=JSON.parse(g));g&&c.DJB(g.data)==g.token?(this.map[f]=g,this.version[f]=g.version,l++):(delete this.map[f],delete this.version[f],b.del(f),h=false)}catch(n){delete this.map[f];delete this.version[f];b.del(f);h=false}}k=Date.now()-k;var m=[require("R").QQVer*10,a.reportKey[j]||0,"20",h?0:1].join("");require("ReportQueue").add("valueStat",["320710",h?1:2,m,{reportRate:h?10:1,duration:k}]);h&&l>0&&(this.resource[j]=i);return h},init:function(e,f){this.sceneKey=e;this.mainModuleName=f;this.getResourceDetail(e);this.getResourceDetail("common");var g=b.get("resource_agentversion");g!=this.agentVer&&(this.version={})}};return a});define("JsBridge",function(){var d=[],e={},b=1,a={},c={call:function(k){var g=["jsbridge:/",k];g.push(b);var j;for(var h=1,l=arguments.length;h<l;h++){var f=arguments[h];if(typeof f=="function"){j=f;break}g.push(encodeURIComponent(typeof f=="object"?JSON.stringify(f):f+""))}a[b]={cb:j};this.callWithScheme(g.join("/"),b);return b++},callBatch:function(f,g){},callWithScheme:function(h,j){var f;for(var g=0;f=d[g];g++){if(!f._busy){break}}(!f||f._busy)&&(f=this.createNewFrame());f._busy=true;e[j]=f;f.src=h},createNewFrame:function(){var f=document.createElement("iframe");d.push(f);f.style.cssText="position:absolute;left:0;top:0;width:0;height:0;visibility:hidden;";f.frameBorder="0";document.body.appendChild(f);return f},callback:function(g,f){console.log("JsBridge.callback: ",g,f);isFinite(g)?a[g]&&(a[g].cb&&a[g].cb(f.result),delete a[g]):f&&f.guid&&a[f.guid]&&(a[f.guid].cb&&a[f.guid].cb(f.data),delete a[f.guid])}};window.JsBridge=c;window.QzoneApp={fire:function(f,g){c.callback(f,g)}};return c});define("ResourceLoader",function(){var b=require("R"),a={config:{},deviceData:{},loadCallback:function(c){var d=require("Merge");if(c&&c.code===0){var f=c.resource&&d.update(c.resource);try{!require(d.mainModuleName)?(d.effect("css"),d.effect("js",function(){require("Init").start();a.config.success&&a.config.success.call(null,c,true)})):f?d.effect("js",function(){require("Init").start();a.config.success&&a.config.success.call(null,c,true)},true):(require("Init").start(),a.config.success&&a.config.success.call(null,c,false))}catch(g){require("Init")&&require("Init").start();a.config.error&&a.config.error.call(null,c)}}else{require("Init")&&require("Init").start();a.config.error&&a.config.error.call(null,c)}},load:function(){var l=require("Merge");this.config.beforeLoad&&this.config.beforeLoad.call(null);var c=a.deviceData.mobileInfo,j={imei:c.imei,mac_addr:c.wifimac,model_info:c.model_name||"",network_type:c.network||"",network_operater:c.mobileType||"",location:c.location||"",imsi:c.imsi||"",android_id:c.androidID||"",os_api_level:c.os_api_level||"",platform:c.platform,resolution:c.resolution,keystr:a.deviceData.sid,uin:a.deviceData.uin,keytype:256,version:"5.0.11.22",from_h5:1,need_tpl:1,agent_ver:"11",scene:this.config.scene||"",ext_ver_json:JSON.stringify(l.version||{}),dayfly:Math.random()},e=[],f,h;for(f in j){h=j[f];e.push(f+"="+encodeURIComponent(h))}if(this.config.param){for(f in this.config.param){h=this.config.param[f];e.push(f+"="+encodeURIComponent(h))}}e=e.join("&");var k=function(){if(JsBridge.call){JsBridge.call("qqZoneAppList/getAPNType",function(n){JsBridge.call("qqZoneAppList/showToast",n>0?"服务器请求失败，请重试":"网络无连接")})}else{var m=require("Api");m.get("APNType",true).then(function(n){m.showMsg(n>0?"服务器请求失败，请重试":"网络无连接")}).start()}},g=Date.now(),d=new XMLHttpRequest();d.timeout=15000;d.onload=function(o){!timestamps[6]&&(timestamps[6]=new Date());g=Date.now()-g;var m=o.target.responseText||"",n=o.target.status;m.substr(-1)==";"&&(m=m.substr(0,m.length-1));try{m=JSON.parse(m);n=m&&m.resultCode;a.loadCallback(m)}catch(p){a.loadCallback({type:p.type,code:999,status:o.target.status});k()}require("ReportQueue").add("valueStatV4",[a.config.url,0===n?1:2,typeof n=="undefined"?999:n,{reportRate:10,duration:g}])};d.ontimeout=d.onerror=function(m){!timestamps[6]&&(timestamps[6]=new Date());g=Date.now()-g;require("ReportQueue").add("valueStatV4",[a.config.url,2,999,{reportRate:1,duration:g}]);a.loadCallback({type:m.type,code:999,status:m.target.status});k()};var i=this.config.type||"GET";!timestamps[5]&&(timestamps[5]=new Date());i.toUpperCase()=="GET"?(d.open(i,this.config.url+(this.config.url.indexOf("?")>-1?"&":"?")+e,true),d.withCredentials=true,d.send()):(d.open(i,this.config.url,true),d.withCredentials=true,d.send(e));require("LocalStorage").set("lastUin",a.deviceData.uin)},init:function(d){this.config=d;!timestamps[4]&&(timestamps[4]=new Date());var e=require("JsBridge"),c=[];b.uin?a.deviceData.uin=b.uin:c.push({ns:"qqZoneAppList",method:"getUin",guid:10000,args:[]});b.sid?a.deviceData.sid=b.sid:c.push({ns:"qqZoneAppList",method:"getSid",guid:10001,args:[]});b.mobileInfo?a.deviceData.mobileInfo=b.mobileInfo:c.push({ns:"qqZoneAppList",method:"getMobileInfo",guid:10002,args:[]});c.length?e.call("qqZoneAppList/callBatch",JSON.stringify(c),500,10,function(f){f&&f.length&&f.forEach(function(h){if(h&&h.length){var g=h[1];g.guid==10000&&(a.deviceData.uin=b.uin=g.data);g.guid==10001&&(a.deviceData.sid=b.sid=g.data);g.guid==10002&&(a.deviceData.mobileInfo=b.mobileInfo=JSON.parse(g.data))}});a.load()}):a.load()}};return a});