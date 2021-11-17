<%@ Page Title="栏目列表" Language="C#" MasterPageFile="~/admin/admin.Master" AutoEventWireup="true" CodeBehind="menu_list.aspx.cs" Inherits="Website.admin.menu_list" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <asp:Label ID="LabelAlert" runat="server" Text="" ForeColor="Red"></asp:Label>
    <asp:GridView ID="GridViewList" runat="server" CellPadding="4" ForeColor="#333333" GridLines="None" Width="100%" AutoGenerateColumns="False" OnRowCommand="GridViewList_RowCommand">
        <AlternatingRowStyle BackColor="White" />
        <Columns>
            <asp:TemplateField HeaderText="操作">
                <ItemTemplate>
                    <asp:HyperLink ID="HyperLinkEdit" runat="server" NavigateUrl='<%# Eval("id","menu_edit.aspx?id={0}") %>'>编辑</asp:HyperLink>
                    <asp:LinkButton ID="LinkButtonDel" runat="server" CommandArgument='<%# Eval("id") %>' CommandName="del">删除</asp:LinkButton>
                </ItemTemplate>
                <HeaderStyle Width="15%" />
            </asp:TemplateField>
            <asp:BoundField DataField="id" HeaderText="标识">
            <HeaderStyle Width="10%" />
            </asp:BoundField>
            <asp:BoundField DataField="title" HeaderText="标题" />
            <asp:BoundField DataField="sort_id" HeaderText="排序">
            <HeaderStyle Width="10%" />
            </asp:BoundField>
        </Columns>
        <EditRowStyle BackColor="#2461BF" />
        <FooterStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
        <HeaderStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
        <PagerStyle BackColor="#2461BF" ForeColor="White" HorizontalAlign="Center" />
        <RowStyle BackColor="#EFF3FB" />
        <SelectedRowStyle BackColor="#D1DDF1" Font-Bold="True" ForeColor="#333333" />
        <SortedAscendingCellStyle BackColor="#F5F7FB" />
        <SortedAscendingHeaderStyle BackColor="#6D95E1" />
        <SortedDescendingCellStyle BackColor="#E9EBEF" />
        <SortedDescendingHeaderStyle BackColor="#4870BE" />
    </asp:GridView>
    
</asp:Content>
