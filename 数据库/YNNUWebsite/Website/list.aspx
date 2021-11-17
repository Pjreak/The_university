<%@ Page Title="" Language="C#" MasterPageFile="~/web.Master" AutoEventWireup="true" CodeBehind="list.aspx.cs" Inherits="Website.list" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="list">
        <div class="leftmenu">
            <ul>
                
                <asp:Repeater ID="RepeaterMenu" runat="server" DataSourceID="SqlDataSourceMenu">
                    <ItemTemplate>
                        <li><a href='<%# Eval("id","list.aspx?id={0}") %>'><%# Eval("title") %></a></li>
                    </ItemTemplate>
                </asp:Repeater>
                <asp:SqlDataSource ID="SqlDataSourceMenu" runat="server" ConnectionString="<%$ ConnectionStrings:ynnuConnectionString %>" SelectCommand="SELECT * FROM [menu] WHERE ([menu_id] = @menu_id) ORDER BY [sort_id]">
                    <SelectParameters>
                        <asp:QueryStringParameter Name="menu_id" QueryStringField="id" Type="Int32" />
                    </SelectParameters>
                </asp:SqlDataSource>
            </ul>
        </div>
        <div class="rightcontent">
            <asp:GridView ID="GridViewArticle" runat="server" Width="100%" AllowPaging="True" AutoGenerateColumns="False" BackColor="White" BorderColor="White" BorderStyle="Ridge" BorderWidth="2px" CellPadding="3" CellSpacing="1" DataKeyNames="id" DataSourceID="SqlDataSourceArticle" GridLines="None">
                <Columns>
                    <asp:HyperLinkField DataNavigateUrlFields="id" DataNavigateUrlFormatString="view.aspx?id={0}" DataTextField="title" HeaderText="文章标题">
                    <ItemStyle Width="80%" />
                    </asp:HyperLinkField>
                    <asp:BoundField DataField="add_time" DataFormatString="{0:yyyy-MM-dd}" HeaderText="日期" SortExpression="add_time">
                    <ItemStyle HorizontalAlign="Center" />
                    </asp:BoundField>
                </Columns>
                <FooterStyle BackColor="#C6C3C6" ForeColor="Black" />
                <HeaderStyle BackColor="#4A3C8C" Font-Bold="True" ForeColor="#E7E7FF" />
                <PagerStyle BackColor="#C6C3C6" ForeColor="Black" HorizontalAlign="Right" />
                <RowStyle BackColor="#DEDFDE" ForeColor="Black" />
                <SelectedRowStyle BackColor="#9471DE" Font-Bold="True" ForeColor="White" />
                <SortedAscendingCellStyle BackColor="#F1F1F1" />
                <SortedAscendingHeaderStyle BackColor="#594B9C" />
                <SortedDescendingCellStyle BackColor="#CAC9C9" />
                <SortedDescendingHeaderStyle BackColor="#33276A" />
            </asp:GridView>

            <asp:SqlDataSource ID="SqlDataSourceArticle" runat="server" ConnectionString="<%$ ConnectionStrings:ynnuConnectionString %>" SelectCommand="SELECT [id], [title], [menu_id], [add_time] FROM [article] WHERE ([menu_id] = @menu_id) ORDER BY [add_time] DESC">
                <SelectParameters>
                    <asp:QueryStringParameter Name="menu_id" QueryStringField="id" Type="Int32" />
                </SelectParameters>
            </asp:SqlDataSource>

        </div>
    </div>
</asp:Content>
