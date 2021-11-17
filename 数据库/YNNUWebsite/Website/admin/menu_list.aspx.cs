using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Website.admin
{
    public partial class menu_list : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if(!IsPostBack)
            {
                GridViewList.DataSource = Tool.menu.GetMenuList(null);
                GridViewList.DataBind();
            }
        }

        protected void GridViewList_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if(e.CommandName=="del")
            {
                int del_id = Tool.Tool.Obj2Int(e.CommandArgument.ToString());
                using (var ctx = new Models.ynnuEntities())
                {
                    if (ctx.menu.Count(s => s.menu_id == del_id) > 0)
                    {
                        LabelAlert.Text = "此栏目有下级，不可删除";
                    }
                    else
                    {
                        if (ctx.article.Count(s => s.menu_id == del_id) > 0)
                        {
                            LabelAlert.Text = "此栏目x下面有文章，不可删除";
                        }
                        else
                        {
                            var menu = ctx.menu.Where(s => s.id == del_id).FirstOrDefault();
                            if (menu != null)
                            {
                                ctx.menu.Remove(menu);
                                if (ctx.SaveChanges() > 0)
                                {
                                    GridViewList.DataSource = Tool.menu.GetMenuList(null);
                                    GridViewList.DataBind();
                                }
                            }
                        }
                    }

                   
                }
            }
        }
    }
}