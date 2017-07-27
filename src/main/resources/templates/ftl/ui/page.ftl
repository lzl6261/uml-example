<#--
分页查询
-->
[#macro page value form]
[#if value.totalResults!=0]
<ul class="pagination">
  <li class="first"><a href="javascript:goPage('${value.firstPage}');">首页</a></li>
  [#if value.currentPage!=value.firstPage]
  <li class="prev"><a href="javascript:goPage('${value.prelinkPage}');"><i class="arrow arrow2"></i>上一页</a></li>
  [/#if]
  [#list value.startPagingLink..value.endPagingLink as item]
  [#if value.currentPage==item]
  <li class="page active"><a>${item}</a></li>
  [#else]
  <li class="page"><a href="javascript:goPage('${item}');">${item}</a></li>
  [/#if]
  [/#list]
  [#if value.currentPage!=value.lastPage]
  <li class="next"><a href="javascript:goPage('${value.postlinkPage}');">下一页<i class="arrow arrow3"></i></a></li>
  [/#if]

  <li class="last"><a href="javascript:goPage('${value.lastPage}');">末页</a></li>
  <li><span>共${value.totalResults}条</span></li>
</ul>

<script type="text/javascript">
  function goPage(pageNo) {
    try{
      var tableForm = document.getElementById('${form}');
      document.getElementById("currentPage").value=pageNo;
      tableForm.onsubmit=null;
      tableForm.submit();
    } catch(e) {
      alert('goPage(pageNo)方法出错');
    }
  }
</script>
[/#if]
[/#macro]