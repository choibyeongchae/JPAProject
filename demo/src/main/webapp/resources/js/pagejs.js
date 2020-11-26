/**
 * 
 */

var goPaging = function(pageNum,pageBlock,url,totalPages,element) {

	var startPage = Math.floor(((pageNum-1)/pageBlock))*pageBlock+1;
	var endPage = startPage + pageBlock - 1;
	var pagesHtml = "";
	
	if (endPage > totalPages) {
		endPage = totalPages;
	}
	
	if (startPage > pageBlock) {
		pagesHtml += "<li><a href=/"+url+"?pageNum="+(startPage - 1)+">prev</a></li>";
	}
	
	for (var i = startPage; i <= endPage; i++) {
		
		if (i == pageNum) {
			pagesHtml += "<li>"+i+"</li>";
		} else {
			pagesHtml += "<li><a href=/"+url+"?pageNum="+i+">"+i+"</a></li>";
		}
	}
	
	if (endPage < totalPages) {
		pagesHtml += "<li><a href=/"+url+"?pageNum="+(startPage + 5)+">next</a></li>";
	}
	
	$(element+" ul").append(pagesHtml);
	
}