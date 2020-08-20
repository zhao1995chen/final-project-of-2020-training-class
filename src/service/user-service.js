import handler from './restful-service'

export default {
  /**
   * 登入 - 取得所有游戏
   * @param {string} loginInfo 账号密码
   */
  getUser: () => handler.get('/api/users/random_user'),
  /**
   * 登入 - 取得所有游戏
   * @param {string} loginInfo 账号密码
   */
  getQuery: (loginInfo = 3) => handler.get('/api/users/random_user?size='+loginInfo),
  /**
   * 登出
   */
  putLogOut: () => handler.post('member/logout'),
  /**
   * 修改自己帳號密碼
   */
  changeSelfPsd: (info) => handler.put('/member/self/password', info),
  /**
   * 修改自己帳號密碼
   */
  dddddd: (info) => handler.patch('/member/self/password', info),
  /**
   * 修改自己帳號密碼
   */
  aaaaa: (info) => handler.delete('/member/self/password'),

}
