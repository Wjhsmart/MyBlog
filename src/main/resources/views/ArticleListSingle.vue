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
          <Table highlight-row ref="dataTable" stripe :loading="table.loading" :columns="table.tableColumns" :data="table.tableDetails" style="margin-top:20px;" @on-current-change="changeCurrent" @on-sort-change="changeSort"></Table>
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
        <FormItem label="文章编号"><Row>
	<i-col span="11">
	<FormItem prop="idMin">
	<InputNumber v-model="searchForm.idMin" placeholder="请输入开始文章编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="idMax">
	<InputNumber v-model="searchForm.idMax" placeholder="请输入结束文章编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="类别编号"><Row>
	<i-col span="11">
	<FormItem prop="categoryIdMin">
	<InputNumber v-model="searchForm.categoryIdMin" placeholder="请输入开始类别编号" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="categoryIdMax">
	<InputNumber v-model="searchForm.categoryIdMax" placeholder="请输入结束类别编号" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="文章标题" prop="title">
	<Input v-model="searchForm.title" placeholder="请输入文章标题"/>
</FormItem>
<FormItem label="封面图片" prop="coverImg">
	<Input v-model="searchForm.coverImg" placeholder="请输入封面图片"/>
</FormItem>
<FormItem label="文章摘要" prop="summary">
	<Input v-model="searchForm.summary" placeholder="请输入文章摘要"/>
</FormItem>
<FormItem label="文章内容" prop="content">
	<Input v-model="searchForm.content" placeholder="请输入文章内容"/>
</FormItem>
<FormItem label="阅读数"><Row>
	<i-col span="11">
	<FormItem prop="viewCountMin">
	<InputNumber v-model="searchForm.viewCountMin" placeholder="请输入开始阅读数" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="viewCountMax">
	<InputNumber v-model="searchForm.viewCountMax" placeholder="请输入结束阅读数" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="评论数"><Row>
	<i-col span="11">
	<FormItem prop="commentCountMin">
	<InputNumber v-model="searchForm.commentCountMin" placeholder="请输入开始评论数" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="commentCountMax">
	<InputNumber v-model="searchForm.commentCountMax" placeholder="请输入结束评论数" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否推荐"><Row>
	<i-col span="11">
	<FormItem prop="recommendMin">
	<InputNumber v-model="searchForm.recommendMin" placeholder="请输入开始是否推荐" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="recommendMax">
	<InputNumber v-model="searchForm.recommendMax" placeholder="请输入结束是否推荐" style="width: 100%;"/>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="创建时间"><Row>
	<i-col span="11">
	<FormItem prop="createTimeMin">
	<DatePicker @on-change="searchForm.createTimeMin=$event" :value="searchForm.createTimeMin" placeholder="请输入开始创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="createTimeMax">
	<DatePicker @on-change="searchForm.createTimeMax=$event" :value="searchForm.createTimeMax" placeholder="请输入结束创建时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="更新时间"><Row>
	<i-col span="11">
	<FormItem prop="updateTimeMin">
	<DatePicker @on-change="searchForm.updateTimeMin=$event" :value="searchForm.updateTimeMin" placeholder="请输入开始更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="updateTimeMax">
	<DatePicker @on-change="searchForm.updateTimeMax=$event" :value="searchForm.updateTimeMax" placeholder="请输入结束更新时间" type="datetime" format="yyyy-MM-dd HH:mm:ss" style="width: 100%;"></DatePicker>
</FormItem>
</i-col>
</Row>
</FormItem>
<FormItem label="是否激活"><Row>
	<i-col span="11">
	<FormItem prop="isActiveMin">
	<InputNumber v-model="searchForm.isActiveMin" placeholder="请输入开始是否激活" style="width: 100%;"/>
</FormItem>
</i-col>
	<i-col span="2" style="text-align: center">-</i-col>
	<i-col span="11">
	<FormItem prop="isActiveMax">
	<InputNumber v-model="searchForm.isActiveMax" placeholder="请输入结束是否激活" style="width: 100%;"/>
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
      <p>文章编号: <span v-text="form.id"></span></p>
<p>类别编号: <span v-text="form.categoryId"></span></p>
<p>文章标题: <span v-text="form.title"></span></p>
<p>封面图片: <span v-text="form.coverImg"></span></p>
<p>文章摘要: <span v-text="form.summary"></span></p>
<p>文章内容: <span v-text="form.content"></span></p>
<p>阅读数: <span v-text="form.viewCount"></span></p>
<p>评论数: <span v-text="form.commentCount"></span></p>
<p>是否推荐: <span v-text="form.recommend"></span></p>
<p>创建时间: <span v-text="form.createTime"></span></p>
<p>更新时间: <span v-text="form.updateTime"></span></p>
<p>是否激活: <span v-text="form.isActive"></span></p>

    </Modal>
  </div>
</template>

<script>
  import * as utils from '@/api/utils'

  export default {
    name: 'ArticleListSingle',
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
          searchUrl: '/article/admin/pager-cond',
          allUrl: '/article/admin/all',
          detailUrl: '/article/admin/one/'
        },
        page: {
          total: 0
        },
        form: {
          id: null,
categoryId: null,
title: null,
coverImg: null,
summary: null,
content: null,
viewCount: null,
commentCount: null,
recommend: null,
createTime: null,
updateTime: null,
isActive: null,

        },
        searchForm: {
          pageNo: 1,
          pageSize: 10,
          sortColumn: null,
          sortOrder: null,
          id: null,
idMin: null, 
idMax: null, 
categoryId: null,
categoryIdMin: null, 
categoryIdMax: null, 
title: null,
coverImg: null,
summary: null,
content: null,
viewCount: null,
viewCountMin: null, 
viewCountMax: null, 
commentCount: null,
commentCountMin: null, 
commentCountMax: null, 
recommend: null,
recommendMin: null, 
recommendMax: null, 
createTime: null,
createTimeMin: null, 
createTimeMax: null, 
updateTime: null,
updateTimeMin: null, 
updateTimeMax: null, 
isActive: null,
isActiveMin: null, 
isActiveMax: null, 

        },
        table: {
          loading: false,
          tableColumns: [
            {
              width: 60,
              align: 'center',
              fixed: "left",
              render: (h, params) => {
                return h('span', params.index + (this.searchForm.pageNo - 1) * this.searchForm.pageSize + 1)
              }
            },
            {
title: '文章编号',
key: 'id',
minWidth: 120,
sortable: true
},
{
title: '类别编号',
key: 'categoryId',
minWidth: 120,
sortable: true
},
{
title: '文章标题',
key: 'title',
minWidth: 120,
sortable: true
},
{
title: '封面图片',
key: 'coverImg',
minWidth: 120,
sortable: true
},
{
title: '文章摘要',
key: 'summary',
minWidth: 120,
sortable: true
},
{
title: '文章内容',
key: 'content',
minWidth: 120,
sortable: true
},
{
title: '阅读数',
key: 'viewCount',
minWidth: 120,
sortable: true
},
{
title: '评论数',
key: 'commentCount',
minWidth: 120,
sortable: true
},
{
title: '是否推荐',
key: 'recommend',
minWidth: 120,
sortable: true
},
{
title: '创建时间',
key: 'createTime',
minWidth: 120,
sortable: true
},
{
title: '更新时间',
key: 'updateTime',
minWidth: 120,
sortable: true
},
{
title: '是否激活',
key: 'isActive',
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
          currentRow: {}
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
      changeCurrent(currentRow, oldCurrentRow) {
        utils.changeCurrent(this, currentRow, oldCurrentRow)
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
