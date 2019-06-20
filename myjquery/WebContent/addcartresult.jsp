<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(function(){
	var bArr=$("div.addcartresult>button");
	$(bArr[0]).click(function(){
		$("nav>ul>li>a[href=productlist]").trigger("click");
		
		//메뉴중 상품목록메뉴찾기
		return false;	
	});
	$(bArr[1]).click(function(){
		//장바구니보기
		$("nav>ul>li>a[href=viewcart]").trigger("click");
		return false;
	});
});
</script>
<div class="addcartresult" style="position:absolute; top:200px; left:100px; width:250px; border:1px solid; background-color: white;">
장바구니에 넣었습니다.
<button class="list">상품목록으로 가기</button>
<button>장바구니로 가기</button>
</div>