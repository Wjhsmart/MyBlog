<template>
  <div>
    <Row>
      <i-col span="24">
        <Card>
          <Button @click="confirmSelection" type="primary">确认选择</Button>&nbsp;
          <Button @click="showModal('search')" type="primary">高级搜索</Button>&nbsp;
          <Tooltip content="刷新" placement="right">
            <Button icon="md-refresh" type="success" shape="circle" @click="search"></Button>
          </Tooltip>
          <Table ref="dataTable" stripe :loading="table.loading" :columns="table.tableColumns" :data="table.tableDetails" style="margin-top:20px;" @on-selection-change="changeSelection" @on-sort-change="changeSort"></Table>
          <div style="margin: 20px;overflow: hidden">
            <div style="float: right;">
              <Page :total="page.total" :current="searchForm.pageNo" @on-change="changePageNo" @on-page-size-change="changePageSize" showSizer showTotal></Page>
            </div>
          </div>
        </Card>
      </i-col>
    </Row>
    <Modal v-model="modal.search" title="高级搜索">
      <Form ref="searchForm" :model="searchForm" :label-width="80">
        <FormItem label="系统信息主键"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始系统信息主键" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束系统信息主键" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="系统名称" prop="title">
	<Input v-model="searchForm.title" placeholder="请输入系统名称"/>
</FormItem>
<FormItem label="说明" prop="desc">
	<Input v-model="searchForm.desc" placeholder="请输入说明"/>
</FormItem>
<FormItem label="备案号" prop="recordNum">
	<Input v-model="searchForm.recordNum" placeholder="请输入备案号"/>
</FormItem>
<FormItem label="域名" prop="domainName">
	<Input v-model="searchForm.domainName" placeholder="请输入域名"/>
</FormItem>
<FormItem label="姓名" prop="name">
	<Input v-model="searchForm.name" placeholder="请输入姓名"/>
</FormItem>
<FormItem label="真实姓名" prop="rename">
	<Input v-model="searchForm.rename" placeholder="请输入真实姓名"/>
</FormItem>
<FormItem label="网名" prop="netName">
	<Input v-model="searchForm.netName" placeholder="请输入网名"/>
</FormItem>
<FormItem label="职业" prop="vocation">
	<Input v-model="searchForm.vocation" placeholder="请输入职业"/>
</FormItem>
<FormItem label="QQ" prop="qq">
	<Input v-model="searchForm.qq" placeholder="请输入QQ"/>
</FormItem>
<FormItem label="微信" prop="wechat">
	<Input v-model="searchForm.wechat" placeholder="请输入微信"/>
</FormItem>
<FormItem label="邮箱" prop="email">
	<Input v-model="searchForm.email" placeholder="请输入邮箱"/>
</FormItem>
<FormItem label="头像" prop="headImg">
	<Input v-model="searchForm.headImg" placeholder="请输入头像"/>
</FormItem>
<FormItem label="微信二维码" prop="wechatCode">
	<Input v-model="searchForm.wechatCode" placeholder="请输入微信二维码"/>
</FormItem>
<FormItem label="格言" prop="motto">
	<Input v-model="searchForm.motto" placeholder="请输入格言"/>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
        <Button type="text" size="large" @click="cancelModal('search')">取消</Button>
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">确定</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>系统信息主键: <span v-text="form.id"></span></p>
<p>系统名称: <span v-text="form.title"></span></p>
<p>说明: <span v-text="form.desc"></span></p>
<p>备案号: <span v-text="form.recordNum"></span></p>
<p>域名: <span v-text="form.domainName"></span></p>
<p>姓名: <span v-text="form.name"></span></p>
<p>真实姓名: <span v-text="form.rename"></span></p>
<p>网名: <span v-text="form.netName"></span></p>
<p>职业: <span v-text="form.vocation"></span></p>
<p>QQ: <span v-text="form.qq"></span></p>
<p>微信: <span v-text="form.wechat"></span></p>
<p>邮箱: <span v-text="form.email"></span></p>
<p>头像: <span v-text="form.headImg"></span></p>
<p>微信二维码: <span v-text="form.wechatCode"></span></p>
<p>格言: <span v-text="form.motto"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'InfoList',
    data() {
      return {
        modal: {
          add: false,
          edit: false,
          search: false,
          detail: false
        },
        loading: {
          search: false
        },
        urls: {
          searchUrl: '/info/admin/pager-cond',
          allUrl: '/info/admin/all',
          detailUrl: '/info/admin/one/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
title: null,
desc: null,
recordNum: null,
domainName: null,
name: null,
rename: null,
netName: null,
vocation: null,
qq: null,
wechat: null,
email: null,
headImg: null,
wechatCode: null,
motto: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          id: null,
idMin: null, 
idMax: null, 
title: null,
desc: null,
recordNum: null,
domainName: null,
name: null,
rename: null,
netName: null,
vocation: null,
qq: null,
wechat: null,
email: null,
headImg: null,
wechatCode: null,
motto: null,

        },
        table: {
          loading: false,
          tableColumns: [
            {
              type: 'selection',
              width: 45,
              key: "id",
              align: 'center',
              fixed: 'left'
            },
            {
              width: 60,
              align: 'center',
              fixed: "left",
              render: (h, params) => {
                return h('span', params.index + (this.searchForm.pageNo - 1) * this.searchForm.pageSize + 1)
              }
            },
            {
title: '系统信息主键',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '系统名称',
key: 'title',
minWidth: 120,
sortable: true
},
{
title: '说明',
key: 'desc',
minWidth: 120,
sortable: true
},
{
title: '备案号',
key: 'recordNum',
minWidth: 120,
sortable: true
},
{
title: '域名',
key: 'domainName',
minWidth: 120,
sortable: true
},
{
title: '姓名',
key: 'name',
minWidth: 120,
sortable: true
},
{
title: '真实姓名',
key: 'rename',
minWidth: 120,
sortable: true
},
{
title: '网名',
key: 'netName',
minWidth: 120,
sortable: true
},
{
title: '职业',
key: 'vocation',
minWidth: 120,
sortable: true
},
{
title: 'QQ',
key: 'qq',
minWidth: 120,
sortable: true
},
{
title: '微信',
key: 'wechat',
minWidth: 120,
sortable: true
},
{
title: '邮箱',
key: 'email',
minWidth: 120,
sortable: true
},
{
title: '头像',
key: 'headImg',
minWidth: 120,
sortable: true
},
{
title: '微信二维码',
key: 'wechatCode',
minWidth: 120,
sortable: true
},
{
title: '格言',
key: 'motto',
minWidth: 120,
sortable: true
},

            {
              title: '操作',
              key: 'action',
              width: 80,
              align: 'center',
              fixed: 'right',
              render: (h, params) => {
                return h('div', [
                  h('Button', {
                    props: {
                      type: 'primary',
                      size: 'small'
                    },
                    style: {
                      marginRight: '5px'
                    },
                    on: {
                      click: () => {
                        this.showDetail('detail', params.row)
                      }
                    }
                  }, '详情')
                ])
              }
            }
          ],
          tableDetails: [],
          selections: []
        }
      }
    },
    computed: {},
    mounted() {
      this.search()
    },
    methods: {
      showModal(modal) {
        utils.showModal(this, modal)
      },
      showDetail(modal, row) {
        utils.showModal(this, modal)
        this.form = row
      },
      changeModalVisibleResetForm(formRef, visible) {
        if (!visible) {
          utils.resetForm(this, formRef)
        }
      },
      resetForm(formRef) {
        utils.resetForm(this, formRef)
      },
      cancelModal(modal) {
        utils.cancelModal(this, modal)
      },
      resetFormCancelModal(formRef, modal) {
        utils.cancelModal(this, modal)
        utils.resetForm(this, formRef)
      },
      searchOkModal(modal) {
        utils.cancelModal(this, modal)
        utils.search(this)
      },
      search() {
        utils.search(this)
      },
      changeSelection(selections) {
        utils.changeSelections(this, selections)
      },
      changeSort(sortColumn) {
        utils.changeSort(this, sortColumn)
      },
      changePageNo(pageNo) {
        utils.changePageNo(this, pageNo)
      },
      changePageSize(pageSize) {
        utils.changePageSize(this, pageSize)
      },
      confirmSelection() {
        // 确认选择的逻辑
      }
    }
  }
</script>

<style>
</style>
