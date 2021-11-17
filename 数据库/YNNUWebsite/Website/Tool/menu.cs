using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Website.Tool
{
    public static class menu
    {
        public static List<Models.menu> GetMenuList(int? menu_id)
        {
            using (var ctx = new Models.ynnuEntities())
            {
                var listmenu = ctx.menu.OrderBy(s => s.id).ToList();
                var listresult =new List<Models.menu>();

                var list = listmenu.Where(s => s.menu_id == menu_id).ToList();
                if(list!=null)
                {
                    foreach(Models.menu menu in list)
                    {
                        listresult.Add(menu);

                        if(listmenu.Count(s=>s.menu_id==menu.id)>0)
                        {
                            GetMenu(listmenu, listresult, menu.id, 1);
                        }
                    }
                }

                return listresult;
            }
        }

        private static void GetMenu(List<Models.menu> listmeun,
            List<Models.menu> listresult,int? menu_id,int depth)
        {
            var list = listmeun.Where(s => s.menu_id == menu_id).ToList();
            if (list != null)
            {
                foreach(Models.menu menu in list)
                {
                    menu.title = "┗" + Tool.Restr("━", depth) + menu.title;
                    listresult.Add(menu);

                    if (listmeun.Count(s => s.menu_id == menu.id) > 0)
                    {
                        GetMenu(listmeun, listresult, menu.id, depth + 1);
                    }
                }
            }

        }
    }
}