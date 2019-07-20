<html>
<head>
    <title>Math Kingdom</title>
</head>
<body>
<div style="text-align:center;">
    <h2>Math Kingdom (freemarker template)</h2>
    <br><br><br>
    <form action="${contextPath}/calculate" method="post" style="text-align:center">
        <table style="margin-left: auto; margin-right: auto; margin-top: auto;">
            <col width="80">
            <col width="150">
            <tr>
                <td style="text-align:right">Variable a:</td>
                <td><input name="a" value="${a!}"></td>
            </tr>
            <tr>
                <td style="text-align:right">
                    <select name="operator" value="${operator!}">
                        <option value="0" <#if operator! == "0">selected</#if>>+</option>
                        <option value="1" <#if operator! == "1">selected</#if>>-</option>
                        <option value="2" <#if operator! == "2">selected</#if>>×</option>
                        <option value="3" <#if operator! == "3">selected</#if>>÷</option>
                    </select>
                </td>
                <td>
                </td>
            </tr>
            <tr>
                <td style="text-align:right">Variable b:</td>
                <td><input name="b" value="${b!}"></td>
            </tr>
            <tr>
                <td style="text-align:right">Result:</td>
                <td><label>${res!}</label></td>
            </tr>
        </table>
        <input type="submit" value="calculate"/>
    </form>
</div>
</body>
</html>
