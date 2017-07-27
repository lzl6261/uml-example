<label class="checkbox-inline"><input type="checkbox"[#rt/]
                                      value="${rkey}" [#if index==0 &&rule!=""] data-rule=${rule}[/#if] name="${name}"[#rt/]
[#if valueList?seq_contains(rkey)] checked="checked"[/#if][#rt/]
/>${rvalue}</label>[#if hasNext] [/#if>