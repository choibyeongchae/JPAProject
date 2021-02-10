/**
 * 
 */

var goPaging = function(pageNum,pageBlock,url,totalPages,element,className) {

	var startPage = Math.floor(((pageNum-1)/pageBlock))*pageBlock+1;
	var endPage = startPage + pageBlock - 1;
	var pagesHtml = "";
	
	if (endPage > totalPages) {
		endPage = totalPages;
	}
	
	if (startPage > pageBlock) {
		pagesHtml += "<li class='"+className+"'><a class = 'page-link' href=/"+url+"?pageNum="+(startPage - 1)+">prev</a></li>";
	}
	
	for (var i = startPage; i <= endPage; i++) {
		
		if (i == pageNum) {
			pagesHtml += "<li class='"+className+" active'><a class = 'page-link'>"+i+"</a></li>";
		} else {
			pagesHtml += "<li class='"+className+"'><a class = 'page-link' href=/"+url+"?pageNum="+i+">"+i+"</a></li>";
		}
	}
	
	if (endPage < totalPages) {
		pagesHtml += "<li class='"+className+"'><a class = 'page-link' href=/"+url+"?pageNum="+(startPage + 5)+">next</a></li>";
	}
	
	$(element+" ul").append(pagesHtml);
	
}