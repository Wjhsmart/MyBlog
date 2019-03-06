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
        <FormItem label="留言表主键"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始留言表主键" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束留言表主键" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="称呼" prop="nickname">
	<Input v-model="searchForm.nickname" placeholder="请输入称呼"/>
</FormItem>
<FormItem label="邮箱" prop="email">
	<Input v-model="searchForm.email" placeholder="请输入邮箱"/>
</FormItem>
<FormItem label="回复标识"><Row>
	<i-col span="11">
	<FormItem prop="replyFlagMin">
	<InputNumber v-model="searchForm.replyFlagMin" placeholder="请输入开始回复标识" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="replyFlagMax">
	<InputNumber v-model="searchForm.replyFlagMax" placeholder="请输入结束回复标识" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="回复内容" prop="replyContent">
	<Input v-model="searchForm.replyContent" placeholder="请输入回复内容"/>
</FormItem>
<FormItem label="回复时间"><Row>
	<i-col span="11">
	<FormItem prop="replyTimeMin">
	<DatePicker @on-change="searchForm.replyTimeMin=$event" :value="searchForm.replyTimeMin" placeholder="请输入开始回复时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="replyTimeMax">
	<DatePicker @on-change="searchForm.replyTimeMax=$event" :value="searchForm.replyTimeMax" placeholder="请输入结束回复时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否已读"><Row>
	<i-col span="11">
	<FormItem prop="readFlagMin">
	<InputNumber v-model="searchForm.readFlagMin" placeholder="请输入开始是否已读" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="readFlagMax">
	<InputNumber v-model="searchForm.readFlagMax" placeholder="请输入结束是否已读" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="提交时间"><Row>
	<i-col span="11">
	<FormItem prop="createTimeMin">
	<DatePicker @on-change="searchForm.createTimeMin=$event" :value="searchForm.createTimeMin" placeholder="请输入开始提交时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="createTimeMax">
	<DatePicker @on-change="searchForm.createTimeMax=$event" :value="searchForm.createTimeMax" placeholder="请输入结束提交时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>

      </Form>
      <div slot="footer">
        <Button type="text" size="large" @click="resetForm('searchForm')">清空</Button>
        <Button type="text" size="large" @click="cancelModal('search')">取消</Button>
        <Button type="primary" size="large" @click="searchOkModal('search')" :loading="loading.search">确定</Button>
      </div>
    </Modal>
    <Modal v-model="modal.detail" title="详情">
      <p>留言表主键: <span v-text="form.id"></span></p>
<p>称呼: <span v-text="form.nickname"></span></p>
<p>邮箱: <span v-text="form.email"></span></p>
<p>回复标识: <span v-text="form.replyFlag"></span></p>
<p>回复内容: <span v-text="form.replyContent"></span></p>
<p>回复时间: <span v-text="form.replyTime"></span></p>
<p>是否已读: <span v-text="form.readFlag"></span></p>
<p>提交时间: <span v-text="form.createTime"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'LeaveWordList',
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
          searchUrl: '/leave-word/admin/pager-cond',
          allUrl: '/leave-word/admin/all',
          detailUrl: '/leave-word/admin/one/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
nickname: null,
email: null,
replyFlag: null,
replyContent: null,
replyTime: null,
readFlag: null,
createTime: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          id: null,
idMin: null, 
idMax: null, 
nickname: null,
email: null,
replyFlag: null,
replyFlagMin: null, 
replyFlagMax: null, 
replyContent: null,
replyTime: null,
replyTimeMin: null, 
replyTimeMax: null, 
readFlag: null,
readFlagMin: null, 
readFlagMax: null, 
createTime: null,
createTimeMin: null, 
createTimeMax: null, 

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
title: '留言表主键',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '称呼',
key: 'nickname',
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
title: '回复标识',
key: 'replyFlag',
minWidth: 120,
sortable: true
},
{
title: '回复内容',
key: 'replyContent',
minWidth: 120,
sortable: true
},
{
title: '回复时间',
key: 'replyTime',
minWidth: 120,
sortable: true
},
{
title: '是否已读',
key: 'readFlag',
minWidth: 120,
sortable: true
},
{
title: '提交时间',
key: 'createTime',
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
